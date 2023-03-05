package com.mfbilgin.kodlama.io.devs.business.concretes;

import com.mfbilgin.kodlama.io.devs.business.abstracts.ProgramingLanguagesService;
import com.mfbilgin.kodlama.io.devs.business.requests.programingLanguage.AddProgramingLanguageRequest;
import com.mfbilgin.kodlama.io.devs.business.requests.programingLanguage.DeleteProgramingLanguageRequest;
import com.mfbilgin.kodlama.io.devs.business.requests.programingLanguage.UpdateProgramingLanguageRequest;
import com.mfbilgin.kodlama.io.devs.business.responses.programingLanguage.GetProgramingLanguageResponse;
import com.mfbilgin.kodlama.io.devs.dataAccess.abstracts.ProgramingLanguagesRepository;
import com.mfbilgin.kodlama.io.devs.entities.ProgramingLanguage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgramingLanguagesManager implements ProgramingLanguagesService {
    private final ProgramingLanguagesRepository programingLanguagesRepository;

    public ProgramingLanguagesManager(ProgramingLanguagesRepository programingLanguagesRepository) {
        this.programingLanguagesRepository = programingLanguagesRepository;
    }

    @Override
    public void add(AddProgramingLanguageRequest programingLanguage) throws Exception {
        ProgramingLanguage programingLanguageToAdd = new ProgramingLanguage();
        programingLanguageToAdd.setName(programingLanguage.getName());
        if (isExist(programingLanguageToAdd))
            throw new Exception("Bu programlama dilini zaten eklediniz.");
        if (programingLanguageToAdd.getName().isBlank())
            throw new Exception("Programlama dilinin adı boş olamaz.");

        programingLanguagesRepository.save(programingLanguageToAdd);
    }

    @Override
    public void update(UpdateProgramingLanguageRequest programingLanguage) throws Exception {
        ProgramingLanguage programingLanguageToUpdate = new ProgramingLanguage();
        programingLanguageToUpdate.setId(programingLanguage.getId());
        programingLanguageToUpdate.setName(programingLanguage.getName());
        if (isExist(programingLanguageToUpdate))
            throw new Exception("Bu programlama dilini zaten eklediniz.");
        if (programingLanguage.getName().isBlank())
            throw new Exception("Programlama dilinin adı boş olamaz.");

        programingLanguagesRepository.save(programingLanguageToUpdate);
    }

    @Override
    public void delete(DeleteProgramingLanguageRequest programingLanguage) {
        ProgramingLanguage programingLanguageToDelete = programingLanguagesRepository.findById(programingLanguage.getId()).get();
        programingLanguagesRepository.delete(programingLanguageToDelete);
    }

    @Override
    public GetProgramingLanguageResponse getById(int id) {
        GetProgramingLanguageResponse programingLanguageResponse = new GetProgramingLanguageResponse();
        ProgramingLanguage programingLanguage = programingLanguagesRepository.findById(id).get();
        programingLanguageResponse.setId(programingLanguage.getId());
        programingLanguageResponse.setName(programingLanguage.getName());
        return programingLanguageResponse;
    }

    @Override
    public List<GetProgramingLanguageResponse> getAll() {
        List<ProgramingLanguage> programingLanguages = programingLanguagesRepository.findAll();
        List<GetProgramingLanguageResponse> programingLanguageResponses = new ArrayList<>();
        for (ProgramingLanguage programingLanguage : programingLanguages) {
            GetProgramingLanguageResponse programingLanguageResponse = new GetProgramingLanguageResponse();
            programingLanguageResponse.setId(programingLanguage.getId());
            programingLanguageResponse.setName(programingLanguage.getName());
            programingLanguageResponses.add(programingLanguageResponse);
        }
        return programingLanguageResponses;
    }

    private boolean isExist(ProgramingLanguage programingLanguage) {
        return programingLanguagesRepository.findAll().stream().anyMatch(p -> p.getName().equals(programingLanguage.getName()));
    }
}
