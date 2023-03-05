package com.mfbilgin.kodlama.io.devs.business.requests.framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddFrameworkRequest {
    private int id;
    private String name;
    private int languageId;

}
