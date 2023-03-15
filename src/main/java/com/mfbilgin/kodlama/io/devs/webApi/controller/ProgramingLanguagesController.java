package com.mfbilgin.kodlama.io.devs.webApi.controller;

import com.mfbilgin.kodlama.io.devs.business.abstracts.ProgramingLanguagesService;
import com.mfbilgin.kodlama.io.devs.business.requests.programingLanguage.AddProgramingLanguageRequest;
import com.mfbilgin.kodlama.io.devs.business.requests.programingLanguage.UpdateProgramingLanguageRequest;
import com.mfbilgin.kodlama.io.devs.business.responses.programingLanguage.GetAllProgramingLanguageResponse;
import com.mfbilgin.kodlama.io.devs.business.responses.programingLanguage.GetByIdProgramingLanguageResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/programingLanguages")
@AllArgsConstructor
public class ProgramingLanguagesController {
    private final ProgramingLanguagesService programingLanguagesService;


    @GetMapping()
    public List<GetAllProgramingLanguageResponse> getAll() {
        return programingLanguagesService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdProgramingLanguageResponse getById(@PathVariable int id) {
        return programingLanguagesService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddProgramingLanguageRequest programingLanguage) throws Exception {
        programingLanguagesService.add(programingLanguage);
    }

    @PutMapping()
    public void update(@RequestBody @Valid UpdateProgramingLanguageRequest programingLanguage) throws Exception {
        programingLanguagesService.update(programingLanguage);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        programingLanguagesService.delete(id);
    }

}
