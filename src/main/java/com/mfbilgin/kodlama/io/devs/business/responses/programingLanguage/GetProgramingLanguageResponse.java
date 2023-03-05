package com.mfbilgin.kodlama.io.devs.business.responses.programingLanguage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProgramingLanguageResponse {
    private int id;
    private String name;
}
