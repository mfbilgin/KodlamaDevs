package com.mfbilgin.kodlama.io.devs.business.responses.framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByLanguageIdFrameworkResponse {
    private int id;
    private String name;
    private String languageName;
}
