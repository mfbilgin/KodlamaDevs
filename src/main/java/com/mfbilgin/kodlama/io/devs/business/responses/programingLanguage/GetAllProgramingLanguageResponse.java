package com.mfbilgin.kodlama.io.devs.business.responses.programingLanguage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgramingLanguageResponse {
    private int id;
    private String name;
    private List<String> frameworks;
}
