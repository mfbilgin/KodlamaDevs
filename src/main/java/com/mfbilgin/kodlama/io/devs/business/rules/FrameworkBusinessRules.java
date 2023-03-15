package com.mfbilgin.kodlama.io.devs.business.rules;

import com.mfbilgin.kodlama.io.devs.core.utilities.exceptions.BusinessException;
import com.mfbilgin.kodlama.io.devs.dataAccess.FrameworkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FrameworkBusinessRules {
    private final FrameworkRepository frameworkRepository;

    public void checkIfFrameworkNameExists(String name){
        if (frameworkRepository.existsByName(name))
            throw new BusinessException(String.format("Framework with name %s already exists",name));
    }

    public void checkIfFrameworkIdNotExists(int frameworkId){
        if(!frameworkRepository.existsById(frameworkId))
            throw new BusinessException(String.format("Framework with id %d not exists",frameworkId));
    }

//    public void checkIfLanguageIdNotExists(ProgramingLanguage languageId){
//        if(!frameworkRepository.existsByLanguage(languageId))
//            throw new BusinessException(String.format("Language id %d not exists",languageId));
//    }
}
