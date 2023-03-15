package com.mfbilgin.kodlama.io.devs.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ValidationProblemDetails extends ProblemDetails{
    private Map<String,String> validationErrors;
}
