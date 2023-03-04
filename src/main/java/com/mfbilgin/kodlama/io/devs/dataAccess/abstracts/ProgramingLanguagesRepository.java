package com.mfbilgin.kodlama.io.devs.dataAccess.abstracts;

import com.mfbilgin.kodlama.io.devs.entities.ProgramingLanguage;

import java.util.List;

public interface ProgramingLanguagesRepository {
    void add(ProgramingLanguage programingLanguage);
    void update(ProgramingLanguage programingLanguage);
    void delete(ProgramingLanguage programingLanguage);
    ProgramingLanguage getById(int id);
    List<ProgramingLanguage> getAll();
}
