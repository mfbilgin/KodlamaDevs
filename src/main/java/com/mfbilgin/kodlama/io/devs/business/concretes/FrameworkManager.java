package com.mfbilgin.kodlama.io.devs.business.concretes;

import com.mfbilgin.kodlama.io.devs.business.abstracts.FrameworkService;
import com.mfbilgin.kodlama.io.devs.business.core.utilities.mappers.ModelMapperService;
import com.mfbilgin.kodlama.io.devs.business.requests.framework.AddFrameworkRequest;
import com.mfbilgin.kodlama.io.devs.business.requests.framework.DeleteFrameworkRequest;
import com.mfbilgin.kodlama.io.devs.business.requests.framework.UpdateFrameworkRequest;
import com.mfbilgin.kodlama.io.devs.business.responses.framework.GetFrameworkResponse;
import com.mfbilgin.kodlama.io.devs.dataAccess.FrameworkRepository;
import com.mfbilgin.kodlama.io.devs.entities.Framework;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FrameworkManager implements FrameworkService {
    private final FrameworkRepository frameworkRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(AddFrameworkRequest request) {
        Framework framework = modelMapperService.forRequest().map(request, Framework.class);
        if (isExist(framework))
            throw new RuntimeException("Bu framework zaten mevcut!");
        frameworkRepository.save(framework);
    }

    @Override
    public void delete(DeleteFrameworkRequest request) {
        Framework framework = modelMapperService.forRequest().map(request, Framework.class);
        frameworkRepository.delete(framework);
    }

    @Override
    public void update(UpdateFrameworkRequest request) {
        Framework framework = modelMapperService.forRequest().map(request, Framework.class);
        Framework frameworkToUpdate = new Framework();
        frameworkToUpdate.setId(framework.getId());
        frameworkToUpdate.setName(framework.getName());
        frameworkToUpdate.setLanguage(framework.getLanguage());
        if (isExist(framework))
            throw new RuntimeException("Bu framework zaten mevcut!");
        frameworkRepository.save(frameworkToUpdate);
    }

    @Override
    public List<GetFrameworkResponse> getAll() {
        List<Framework> frameworks = frameworkRepository.findAll();
        return getGetFrameworkResponses(frameworks);
    }

    private List<GetFrameworkResponse> getGetFrameworkResponses(List<Framework> frameworks) {
        List<GetFrameworkResponse> responses = frameworks.stream().map(framework -> {
            GetFrameworkResponse response = new GetFrameworkResponse();
            response.setId(framework.getId());
            response.setName(framework.getName());
            response.setLanguage(framework.getLanguage().getName());
            return response;
        }).toList();
        return responses.isEmpty() ? null : responses;
    }

    @Override
    public List<GetFrameworkResponse> getByLanguageId(int languageId) {
        List<Framework> frameworks = frameworkRepository.getByLanguageId(languageId);
        return getGetFrameworkResponses(frameworks);
    }


    @Override
    public GetFrameworkResponse getById(int id) {
        return frameworkRepository.findById(id).map(framework -> {
            GetFrameworkResponse response = new GetFrameworkResponse();
            response.setId(framework.getId());
            response.setName(framework.getName());
            response.setLanguage(framework.getLanguage().getName());
            return response;
        }).orElse(null);
    }

    private boolean isExist(Framework framework) {
        return frameworkRepository.findAll().stream().anyMatch(f -> f.getName().equals(framework.getName()) && f.getLanguage().getId() == (framework.getLanguage().getId()));
    }
}
