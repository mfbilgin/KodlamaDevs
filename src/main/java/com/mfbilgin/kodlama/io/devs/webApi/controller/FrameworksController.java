package com.mfbilgin.kodlama.io.devs.webApi.controller;

import com.mfbilgin.kodlama.io.devs.business.abstracts.FrameworkService;
import com.mfbilgin.kodlama.io.devs.business.requests.framework.AddFrameworkRequest;
import com.mfbilgin.kodlama.io.devs.business.requests.framework.UpdateFrameworkRequest;
import com.mfbilgin.kodlama.io.devs.business.responses.framework.GetAllFrameworkResponse;
import com.mfbilgin.kodlama.io.devs.business.responses.framework.GetByIdFrameworkResponse;
import com.mfbilgin.kodlama.io.devs.business.responses.framework.GetByLanguageIdFrameworkResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/frameworks")
@AllArgsConstructor
public class FrameworksController {
    private final FrameworkService frameworkService;

    @GetMapping()
    public List<GetAllFrameworkResponse> getAll() {
        return frameworkService.getAll();
    }

    @GetMapping("/getByLanguageId/{languageId}")
    public List<GetByLanguageIdFrameworkResponse> getByLanguageId(@PathVariable int languageId) {
        return frameworkService.getByLanguageId(languageId);
    }

    @GetMapping("/{id}")
    public GetByIdFrameworkResponse getById(@PathVariable int id) {
        return frameworkService.getById(id);
    }

    @PostMapping()
    public void add(@RequestBody AddFrameworkRequest request) {
        frameworkService.add(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        frameworkService.delete(id);
    }

    @PutMapping()
    public void update(@RequestBody UpdateFrameworkRequest request) {
        frameworkService.update(request);
    }
}
