package com.mfbilgin.kodlama.io.devs.business.requests.programingLanguage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProgramingLanguageRequest {
    private int id;
    private String name;
}
