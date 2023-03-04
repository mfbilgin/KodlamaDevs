package com.mfbilgin.kodlama.io.devs.webApi.controller;

import com.mfbilgin.kodlama.io.devs.business.abstracts.ProgramingLanguagesService;
import com.mfbilgin.kodlama.io.devs.dataAccess.abstracts.ProgramingLanguagesRepository;
import com.mfbilgin.kodlama.io.devs.entities.ProgramingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programingLanguages")
public class ProgramingLanguagesController {
    private final ProgramingLanguagesService programingLanguagesService;


    public ProgramingLanguagesController(ProgramingLanguagesService programingLanguagesService) {
        this.programingLanguagesService = programingLanguagesService;
    }
    @GetMapping("/getAll")
    public List<ProgramingLanguage> getAll()
    {
        return programingLanguagesService.getAll();
    }
    @GetMapping("/getById")
    public ProgramingLanguage getById(int id){
        return programingLanguagesService.getById(id);
    }
    @PostMapping("/add")
    public List<ProgramingLanguage> add(@RequestBody ProgramingLanguage programingLanguage) throws Exception
    {
        programingLanguagesService.add(programingLanguage);
        return programingLanguagesService.getAll();
    }
    @PostMapping("/update")
    public List<ProgramingLanguage> update(@RequestBody ProgramingLanguage programingLanguage) throws Exception {
        programingLanguagesService.update(programingLanguage);
        return programingLanguagesService.getAll();
    }
    @PostMapping("/delete")
    public List<ProgramingLanguage> delete(@RequestBody ProgramingLanguage programingLanguage) {
        programingLanguagesService.delete(programingLanguage);
        return programingLanguagesService.getAll();
    }

}
