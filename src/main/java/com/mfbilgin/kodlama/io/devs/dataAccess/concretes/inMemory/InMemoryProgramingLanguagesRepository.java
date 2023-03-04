package com.mfbilgin.kodlama.io.devs.dataAccess.concretes.inMemory;

import com.mfbilgin.kodlama.io.devs.dataAccess.abstracts.ProgramingLanguagesRepository;
import com.mfbilgin.kodlama.io.devs.entities.ProgramingLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProgramingLanguagesRepository implements ProgramingLanguagesRepository {

    List<ProgramingLanguage> programingLanguages;

    public InMemoryProgramingLanguagesRepository() {
        programingLanguages = new ArrayList<ProgramingLanguage>();
        programingLanguages.add(new ProgramingLanguage(1,"Java"));
        programingLanguages.add(new ProgramingLanguage(2,"C#"));
    }

    @Override
    public void add(ProgramingLanguage programingLanguage) {
        programingLanguages.add(programingLanguage);
    }

    @Override
    public void update(ProgramingLanguage programingLanguage) {
        programingLanguages.set(programingLanguage.getId() - 1, programingLanguage);
    }

    @Override
    public void delete(ProgramingLanguage programingLanguage) {
        programingLanguages.remove(programingLanguage.getId() - 1);
    }

    @Override
    public ProgramingLanguage getById(int id) {
        return programingLanguages.get(id - 1);
    }

    @Override
    public List<ProgramingLanguage> getAll() {
        return programingLanguages;
    }
}
