package com.mfbilgin.kodlama.io.devs.business.concretes;

import com.mfbilgin.kodlama.io.devs.business.abstracts.ProgramingLanguagesService;
import com.mfbilgin.kodlama.io.devs.business.requests.programingLanguage.AddProgramingLanguageRequest;
import com.mfbilgin.kodlama.io.devs.business.requests.programingLanguage.UpdateProgramingLanguageRequest;
import com.mfbilgin.kodlama.io.devs.business.responses.programingLanguage.GetAllProgramingLanguageResponse;
import com.mfbilgin.kodlama.io.devs.business.responses.programingLanguage.GetByIdProgramingLanguageResponse;
import com.mfbilgin.kodlama.io.devs.business.rules.ProgramingLanguagesBusinessRules;
import com.mfbilgin.kodlama.io.devs.core.utilities.mappers.ModelMapperService;
import com.mfbilgin.kodlama.io.devs.dataAccess.ProgramingLanguagesRepository;
import com.mfbilgin.kodlama.io.devs.entities.Framework;
import com.mfbilgin.kodlama.io.devs.entities.ProgramingLanguage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProgramingLanguagesManager implements ProgramingLanguagesService {
    private final ProgramingLanguagesRepository programingLanguagesRepository;
    private final ProgramingLanguagesBusinessRules programingLanguagesBusinessRules;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(AddProgramingLanguageRequest request) {
        programingLanguagesBusinessRules.checkIfLanguageNameExists(request.getName());
        ProgramingLanguage programingLanguage = modelMapperService.forRequest().map(request, ProgramingLanguage.class);
        programingLanguagesRepository.save(programingLanguage);
    }

    @Override
    public void update(UpdateProgramingLanguageRequest request) {
        programingLanguagesBusinessRules.checkIfLanguageNameExists(request.getName());
        ProgramingLanguage programingLanguage = modelMapperService.forRequest().map(request, ProgramingLanguage.class);
        programingLanguagesRepository.save(programingLanguage);
    }

    @Override
    public void delete(int id) {
        programingLanguagesBusinessRules.checkIfIdNotExists(id);
        programingLanguagesRepository.deleteById(id);
    }
    @Override
    public GetByIdProgramingLanguageResponse getById(int id) {
        programingLanguagesBusinessRules.checkIfIdNotExists(id);
        ProgramingLanguage programingLanguage = programingLanguagesRepository.findById(id).orElse(null);
        return modelMapperService.forResponse().map(programingLanguage, GetByIdProgramingLanguageResponse.class);
    }

    @Override
    public List<GetAllProgramingLanguageResponse> getAll() {
        List<ProgramingLanguage> programingLanguages = programingLanguagesRepository.findAll();
        List<GetAllProgramingLanguageResponse> responses;
        responses = programingLanguages.stream().map(programingLanguage -> modelMapperService.forResponse()
                .map(programingLanguage, GetAllProgramingLanguageResponse.class)).toList();
        for (GetAllProgramingLanguageResponse response : responses) {
            response.setFrameworkNames(programingLanguages.stream().filter(programingLanguage -> programingLanguage.getId() == response.getId())
                    .map(programingLanguage -> programingLanguage.getFrameworks().stream().map(Framework::getName).toList())
                    .flatMap(List::stream).toList());
        }
        return responses;
    }
}
