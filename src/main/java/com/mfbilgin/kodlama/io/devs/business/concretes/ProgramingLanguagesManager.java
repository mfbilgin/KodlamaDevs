package com.mfbilgin.kodlama.io.devs.business.concretes;

import com.mfbilgin.kodlama.io.devs.business.abstracts.FrameworkService;
import com.mfbilgin.kodlama.io.devs.business.abstracts.ProgramingLanguagesService;
import com.mfbilgin.kodlama.io.devs.business.requests.programingLanguage.AddProgramingLanguageRequest;
import com.mfbilgin.kodlama.io.devs.business.requests.programingLanguage.UpdateProgramingLanguageRequest;
import com.mfbilgin.kodlama.io.devs.business.responses.framework.GetAllFrameworkResponse;
import com.mfbilgin.kodlama.io.devs.business.responses.framework.GetByLanguageIdFrameworkResponse;
import com.mfbilgin.kodlama.io.devs.business.responses.programingLanguage.GetAllProgramingLanguageResponse;
import com.mfbilgin.kodlama.io.devs.business.responses.programingLanguage.GetByIdProgramingLanguageResponse;
import com.mfbilgin.kodlama.io.devs.core.utilities.mappers.ModelMapperService;
import com.mfbilgin.kodlama.io.devs.dataAccess.ProgramingLanguagesRepository;
import com.mfbilgin.kodlama.io.devs.entities.Framework;
import com.mfbilgin.kodlama.io.devs.entities.ProgramingLanguage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProgramingLanguagesManager implements ProgramingLanguagesService {
    private final ProgramingLanguagesRepository programingLanguagesRepository;
    private final FrameworkService frameworkService;
    private final ModelMapperService modelMapperService;


    @Override
    public void add(AddProgramingLanguageRequest request) throws Exception {
        ProgramingLanguage language = modelMapperService.forRequest().map(request, ProgramingLanguage.class);
        if (language.getName().isEmpty()) throw new Exception("Programing Language name can not be empty");
        if (isExist(language.getName())) throw new Exception("Programing Language is already exist!");
        programingLanguagesRepository.save(language);
    }

    @Override
    public void update(UpdateProgramingLanguageRequest request) throws Exception {
        ProgramingLanguage language = modelMapperService.forRequest().map(request, ProgramingLanguage.class);
        if (language.getName().isEmpty()) throw new Exception("Programing Language name can not be empty");
        if (isExist(language.getName())) throw new Exception("Programing Language is already exist!");
        programingLanguagesRepository.save(language);
    }

    @Override
    public void delete(int id) {
        programingLanguagesRepository.deleteById(id);
    }

    @Override
    public GetByIdProgramingLanguageResponse getById(int id) {
        ProgramingLanguage language = programingLanguagesRepository.findById(id).orElse(null);
        GetByIdProgramingLanguageResponse response =  language == null ? null : modelMapperService.forResponse().map(language, GetByIdProgramingLanguageResponse.class);
        if(response.getFrameworks().size() != 0) response.setFrameworks(getAllFrameworkNamesByLanguage(id));
        return response;
    }

    @Override
    public List<GetAllProgramingLanguageResponse> getAll() {
        List<String> strings = new ArrayList<>();
        List<GetAllProgramingLanguageResponse> languages = programingLanguagesRepository.findAll().stream().map(language -> modelMapperService.forResponse().map(language, GetAllProgramingLanguageResponse.class)).toList();
        languages.stream().peek(language ->{
            if(language.getFrameworks().size() != 0 )language.setFrameworks(getAllFrameworkNamesByLanguage(language.getId()));
        }).collect(Collectors.toList());
        return languages;

    }


    private boolean isExist(String name) {
        return programingLanguagesRepository.existsByName(name);
    }


    private List<String> getAllFrameworkNamesByLanguage(int id) {
        List<GetByLanguageIdFrameworkResponse> frameworks = frameworkService.getByLanguageId(id).stream().map(framework -> modelMapperService.forResponse().map(framework, GetByLanguageIdFrameworkResponse.class)).toList();
        List<String> frameworkNames = new ArrayList<>();
        for (GetByLanguageIdFrameworkResponse framework : frameworks) {
            frameworkNames.add(framework.getName());
        }
        return frameworkNames;
    }
}
