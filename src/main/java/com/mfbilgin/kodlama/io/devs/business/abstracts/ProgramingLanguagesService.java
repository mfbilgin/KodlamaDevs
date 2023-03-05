package com.mfbilgin.kodlama.io.devs.business.abstracts;

import com.mfbilgin.kodlama.io.devs.business.requests.programingLanguage.AddProgramingLanguageRequest;
import com.mfbilgin.kodlama.io.devs.business.requests.programingLanguage.DeleteProgramingLanguageRequest;
import com.mfbilgin.kodlama.io.devs.business.requests.programingLanguage.UpdateProgramingLanguageRequest;
import com.mfbilgin.kodlama.io.devs.business.responses.programingLanguage.GetProgramingLanguageResponse;

import java.util.List;

public interface ProgramingLanguagesService {
    void add(AddProgramingLanguageRequest programingLanguage) throws Exception;
    void update(UpdateProgramingLanguageRequest programingLanguage) throws Exception;
    void delete(DeleteProgramingLanguageRequest programingLanguage);
    GetProgramingLanguageResponse getById(int id);
    List<GetProgramingLanguageResponse> getAll();
}
