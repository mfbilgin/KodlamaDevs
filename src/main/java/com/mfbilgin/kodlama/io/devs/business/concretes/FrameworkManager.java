package com.mfbilgin.kodlama.io.devs.business.concretes;

import com.mfbilgin.kodlama.io.devs.business.abstracts.FrameworkService;
import com.mfbilgin.kodlama.io.devs.business.responses.framework.GetByIdFrameworkResponse;
import com.mfbilgin.kodlama.io.devs.business.responses.framework.GetByLanguageIdFrameworkResponse;
import com.mfbilgin.kodlama.io.devs.core.utilities.mappers.ModelMapperService;
import com.mfbilgin.kodlama.io.devs.business.requests.framework.AddFrameworkRequest;
import com.mfbilgin.kodlama.io.devs.business.requests.framework.UpdateFrameworkRequest;
import com.mfbilgin.kodlama.io.devs.business.responses.framework.GetAllFrameworkResponse;
import com.mfbilgin.kodlama.io.devs.dataAccess.FrameworkRepository;
import com.mfbilgin.kodlama.io.devs.entities.Framework;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    public void delete(int id) {
        frameworkRepository.deleteById(id);
    }

    @Override
    public void update(UpdateFrameworkRequest request) {
        Framework framework = modelMapperService.forRequest().map(request, Framework.class);
        if (isExist(framework))
            throw new RuntimeException("Bu framework zaten mevcut!");
        frameworkRepository.save(framework);
    }

    @Override
    public List<GetAllFrameworkResponse> getAll() {
        List<Framework> frameworks = frameworkRepository.findAll();
        List<GetAllFrameworkResponse> responses = frameworks.stream().map(framework -> {
            GetAllFrameworkResponse getAllFrameworkResponse = modelMapperService.forResponse()
                    .map(framework, GetAllFrameworkResponse.class);
            getAllFrameworkResponse.setLanguage(framework.getLanguage().getName());
            return getAllFrameworkResponse;
        }).collect(Collectors.toList());
        return responses.isEmpty() ? null : responses;
    }


    @Override
    public List<GetByLanguageIdFrameworkResponse> getByLanguageId(int languageId) {
        List<Framework> frameworks = frameworkRepository.getByLanguageId(languageId);
        if (frameworks.size() == 0) return null;
        List<GetByLanguageIdFrameworkResponse> responses = frameworks.stream().map(framework -> {
            GetByLanguageIdFrameworkResponse getByLanguageIdFrameworkResponse = modelMapperService.forResponse()
                    .map(framework, GetByLanguageIdFrameworkResponse.class);
            getByLanguageIdFrameworkResponse.setLanguage(framework.getLanguage().getName());
            return getByLanguageIdFrameworkResponse;
        }).collect(Collectors.toList());
        return responses.isEmpty() ? null : responses;
    }


    @Override
    public GetByIdFrameworkResponse getById(int id) {
        Framework framework = frameworkRepository.findById(id).orElse(null);
        GetByIdFrameworkResponse response = modelMapperService.forResponse().map(framework, GetByIdFrameworkResponse.class);
        response.setLanguage(Objects.requireNonNull(framework).getLanguage().getName());
        return response;
    }

    private boolean isExist(Framework framework) {
        return frameworkRepository.findAll().stream().anyMatch(f -> f.getName().equals(framework.getName()) && f.getLanguage().getId() == (framework.getLanguage().getId()));
    }

}
