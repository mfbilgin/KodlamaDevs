package com.mfbilgin.kodlama.io.devs.webApi.controller;

import com.mfbilgin.kodlama.io.devs.business.abstracts.FrameworkService;
import com.mfbilgin.kodlama.io.devs.business.requests.framework.AddFrameworkRequest;
import com.mfbilgin.kodlama.io.devs.business.requests.framework.DeleteFrameworkRequest;
import com.mfbilgin.kodlama.io.devs.business.requests.framework.UpdateFrameworkRequest;
import com.mfbilgin.kodlama.io.devs.business.responses.framework.GetFrameworkResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/frameworks")
@AllArgsConstructor
public class FrameworksController {
    private final FrameworkService frameworkService;

    @GetMapping("/getAll")
    public List<GetFrameworkResponse> getAll(){
        return frameworkService.getAll();
    }

    @GetMapping("/getByLanguageId/{languageId}")
    public List<GetFrameworkResponse> getByLanguageId(@PathVariable int languageId){
        return frameworkService.getByLanguageId(languageId);
    }
    @GetMapping("/getById/{id}")
    public GetFrameworkResponse getById(@PathVariable int id){
        return frameworkService.getById(id);
    }
    @PostMapping("/add")
    public List<GetFrameworkResponse> add(@RequestBody AddFrameworkRequest request){
        frameworkService.add(request);
        return frameworkService.getAll();
    }
    @PostMapping("/delete")
    public List<GetFrameworkResponse> delete(@RequestBody DeleteFrameworkRequest request){
        frameworkService.delete(request);
        return frameworkService.getAll();
    }
    @PostMapping("/update")
    public List<GetFrameworkResponse> update(@RequestBody UpdateFrameworkRequest request){
        frameworkService.update(request);
        return frameworkService.getAll();
    }
}
