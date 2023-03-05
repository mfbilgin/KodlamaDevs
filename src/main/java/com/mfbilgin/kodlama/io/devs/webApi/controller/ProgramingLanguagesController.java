package com.mfbilgin.kodlama.io.devs.webApi.controller;

import com.mfbilgin.kodlama.io.devs.business.abstracts.ProgramingLanguagesService;
import com.mfbilgin.kodlama.io.devs.business.requests.programingLanguage.AddProgramingLanguageRequest;
import com.mfbilgin.kodlama.io.devs.business.requests.programingLanguage.DeleteProgramingLanguageRequest;
import com.mfbilgin.kodlama.io.devs.business.requests.programingLanguage.UpdateProgramingLanguageRequest;
import com.mfbilgin.kodlama.io.devs.business.responses.programingLanguage.GetProgramingLanguageResponse;
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
    public List<GetProgramingLanguageResponse> getAll()
    {
        return programingLanguagesService.getAll();
    }
    @GetMapping("/getById")
    public GetProgramingLanguageResponse getById(int id){
        return programingLanguagesService.getById(id);
    }
    @PostMapping("/add")
    public List<GetProgramingLanguageResponse> add(@RequestBody AddProgramingLanguageRequest programingLanguage) throws Exception
    {
        programingLanguagesService.add(programingLanguage);
        return programingLanguagesService.getAll();
    }
    @PostMapping("/update")
    public List<GetProgramingLanguageResponse> update(@RequestBody UpdateProgramingLanguageRequest programingLanguage) throws Exception {
        programingLanguagesService.update(programingLanguage);
        return programingLanguagesService.getAll();
    }
    @PostMapping("/delete")
    public List<GetProgramingLanguageResponse> delete(@RequestBody DeleteProgramingLanguageRequest programingLanguage) {
        programingLanguagesService.delete(programingLanguage);
        return programingLanguagesService.getAll();
    }

}
