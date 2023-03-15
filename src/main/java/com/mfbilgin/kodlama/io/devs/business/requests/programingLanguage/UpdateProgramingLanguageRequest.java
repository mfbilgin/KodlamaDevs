package com.mfbilgin.kodlama.io.devs.business.requests.programingLanguage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProgramingLanguageRequest {
    private int id;
    @NotBlank
    @NotNull
    private String name;
}
