package com.mfbilgin.kodlama.io.devs.business.concretes;

import com.mfbilgin.kodlama.io.devs.business.abstracts.FrameworkService;
import com.mfbilgin.kodlama.io.devs.business.requests.framework.AddFrameworkRequest;
import com.mfbilgin.kodlama.io.devs.business.requests.framework.UpdateFrameworkRequest;
import com.mfbilgin.kodlama.io.devs.business.responses.framework.GetAllFrameworkResponse;
import com.mfbilgin.kodlama.io.devs.business.responses.framework.GetByIdFrameworkResponse;
import com.mfbilgin.kodlama.io.devs.business.responses.framework.GetByLanguageIdFrameworkResponse;
import com.mfbilgin.kodlama.io.devs.business.rules.FrameworkBusinessRules;
import com.mfbilgin.kodlama.io.devs.core.utilities.mappers.ModelMapperService;
import com.mfbilgin.kodlama.io.devs.dataAccess.FrameworkRepository;
import com.mfbilgin.kodlama.io.devs.entities.Framework;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FrameworkManager implements FrameworkService {
    private final FrameworkRepository frameworkRepository;
    private final FrameworkBusinessRules frameworkBusinessRules;
    private final ModelMapperService modelMapperService;


    @Override
    public void add(AddFrameworkRequest request) {
        frameworkBusinessRules.checkIfFrameworkNameExists(request.getName());
        Framework framework = modelMapperService.forRequest().map(request,Framework.class);
        frameworkRepository.save(framework);
    }

    @Override
    public void update(UpdateFrameworkRequest request) {
        frameworkBusinessRules.checkIfFrameworkNameExists(request.getName());
        Framework framework = modelMapperService.forRequest().map(request,Framework.class);
        frameworkRepository.save(framework);

    }

    @Override
    public void delete(int id) {
        frameworkBusinessRules.checkIfFrameworkIdNotExists(id);
        frameworkRepository.deleteById(id);
    }

    @Override
    public List<GetAllFrameworkResponse> getAll() {
        List<Framework> frameworks = frameworkRepository.findAll();
        return frameworks.stream().map(framework -> modelMapperService.forResponse()
                .map(framework,GetAllFrameworkResponse.class)).toList();
    }

    @Override
    public List<GetByLanguageIdFrameworkResponse> getByLanguageId(int languageId) {
        List<Framework> frameworks = frameworkRepository.findAllByLanguage_Id(languageId);
        return frameworks.stream().map(framework -> modelMapperService.forResponse()
                .map(framework,GetByLanguageIdFrameworkResponse.class)).toList();
    }

    @Override
    public GetByIdFrameworkResponse getById(int id) {
        frameworkBusinessRules.checkIfFrameworkIdNotExists(id);
        Framework framework = frameworkRepository.findById(id).orElse(null);
        return modelMapperService.forResponse().map(framework,GetByIdFrameworkResponse.class);
    }
}