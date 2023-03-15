package com.mfbilgin.kodlama.io.devs.business.rules;

import com.mfbilgin.kodlama.io.devs.core.utilities.exceptions.BusinessException;
import com.mfbilgin.kodlama.io.devs.dataAccess.ProgramingLanguagesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProgramingLanguagesBusinessRules {
    private final ProgramingLanguagesRepository programingLanguagesRepository;

    public void checkIfLanguageNameExists(String name) {
        if (programingLanguagesRepository.existsByName(name))
            throw new BusinessException(String.format("Programing Language with name %s already exists", name));
    }

    public void checkIfIdNotExists(int id){
        if(!programingLanguagesRepository.existsById(id))
            throw new BusinessException(String.format("Programing Language with id %d not exists", id));
    }

}
