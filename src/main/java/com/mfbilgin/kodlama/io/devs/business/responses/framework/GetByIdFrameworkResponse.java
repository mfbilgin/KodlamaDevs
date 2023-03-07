package com.mfbilgin.kodlama.io.devs.business.responses.framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdFrameworkResponse {
    private int id;
    private String name;
    private String language;
}
