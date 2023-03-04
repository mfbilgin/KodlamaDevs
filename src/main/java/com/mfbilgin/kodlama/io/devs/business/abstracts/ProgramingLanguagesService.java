package com.mfbilgin.kodlama.io.devs.business.abstracts;

import com.mfbilgin.kodlama.io.devs.entities.ProgramingLanguage;

import java.util.List;

public interface ProgramingLanguagesService {
    void add(ProgramingLanguage programingLanguage) throws Exception;
    void update(ProgramingLanguage programingLanguage) throws Exception;
    void delete(ProgramingLanguage programingLanguage);
    ProgramingLanguage getById(int id);
    List<ProgramingLanguage> getAll();
}
