package com.mfbilgin.kodlama.io.devs.business.responses.programingLanguage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdProgramingLanguageResponse {
    private int id;
    private String name;
    private List<String> frameworkName;
}
