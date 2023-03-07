package com.mfbilgin.kodlama.io.devs.business.abstracts;

import com.mfbilgin.kodlama.io.devs.business.requests.programingLanguage.AddProgramingLanguageRequest;
import com.mfbilgin.kodlama.io.devs.business.requests.programingLanguage.UpdateProgramingLanguageRequest;
import com.mfbilgin.kodlama.io.devs.business.responses.programingLanguage.GetAllProgramingLanguageResponse;
import com.mfbilgin.kodlama.io.devs.business.responses.programingLanguage.GetByIdProgramingLanguageResponse;

import java.util.List;

public interface ProgramingLanguagesService {
    void add(AddProgramingLanguageRequest request) throws Exception;
    void update(UpdateProgramingLanguageRequest request) throws Exception;
    void delete(int id);
    GetByIdProgramingLanguageResponse getById(int id);
    List<GetAllProgramingLanguageResponse> getAll();
}
