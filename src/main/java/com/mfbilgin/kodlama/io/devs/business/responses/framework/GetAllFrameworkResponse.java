package com.mfbilgin.kodlama.io.devs.business.responses.framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllFrameworkResponse {
    private int id;
    private String name;
    private String languageName;
}
