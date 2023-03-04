package com.mfbilgin.kodlama.io.devs.business.concretes;

import com.mfbilgin.kodlama.io.devs.business.abstracts.ProgramingLanguagesService;
import com.mfbilgin.kodlama.io.devs.dataAccess.abstracts.ProgramingLanguagesRepository;
import com.mfbilgin.kodlama.io.devs.entities.ProgramingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramingLanguagesManager implements ProgramingLanguagesService {
    private final ProgramingLanguagesRepository programingLanguagesRepository;


    public ProgramingLanguagesManager(ProgramingLanguagesRepository programingLanguagesRepository) {
        this.programingLanguagesRepository = programingLanguagesRepository;
    }

    @Override
    public void add(ProgramingLanguage programingLanguage) throws Exception {
        if (isExist(programingLanguage))
            throw new Exception("Bu programlama dilini zaten eklediniz.");
        if (programingLanguage.getName().isBlank())
            throw new Exception("Programlama dilinin adı boş olamaz.");
        programingLanguage.setId(getLastId()+1);
        programingLanguagesRepository.add(programingLanguage);
    }

    @Override
    public void update(ProgramingLanguage programingLanguage) throws Exception {
        if (isExist(programingLanguage))
            throw new Exception("Bu programlama dilini zaten eklediniz.");
        if (programingLanguage.getName().isBlank())
            throw new Exception("Programlama dilinin adı boş olamaz.");
        programingLanguagesRepository.update(programingLanguage);
    }

    @Override
    public void delete(ProgramingLanguage programingLanguage) {
        programingLanguagesRepository.delete(programingLanguage);
    }

    @Override
    public ProgramingLanguage getById(int id) {
        return programingLanguagesRepository.getById(id);
    }
    @Override
    public List<ProgramingLanguage> getAll()
    {
        return programingLanguagesRepository.getAll();
    }
    private boolean isExist(ProgramingLanguage programingLanguage){
        return programingLanguagesRepository.getAll().stream().anyMatch(p->p.getName().equals(programingLanguage.getName()));
    }
    private int getLastId(){
        return programingLanguagesRepository.getAll().size();
    }

}
