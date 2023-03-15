package com.mfbilgin.kodlama.io.devs;

import com.mfbilgin.kodlama.io.devs.core.utilities.exceptions.BusinessException;
import com.mfbilgin.kodlama.io.devs.core.utilities.exceptions.ProblemDetails;
import com.mfbilgin.kodlama.io.devs.core.utilities.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Objects;

@SpringBootApplication
@RestControllerAdvice
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleBusinessException(BusinessException businessException) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(businessException.getMessage());
        return problemDetails;
    }
    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setMessage("VALIDATION ERROR");
        validationProblemDetails.setValidationErrors(new HashMap<>());
        for (FieldError fieldError :methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            validationProblemDetails.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return validationProblemDetails;

    }
    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleJpaObjectRetrievalFailureExceptionException(JpaObjectRetrievalFailureException jpaObjectRetrievalFailureException) {
        ProblemDetails problemDetails = new ProblemDetails();
        String[] messages = Objects.requireNonNull(jpaObjectRetrievalFailureException.getMessage()).split(" ");
        String message = messages[messages.length - 4].split("\\.")[6] + " " + messages[messages.length - 3] + " " + messages[messages.length - 2] + " " + messages[messages.length - 1] + " not found";
        problemDetails.setMessage(message);
        //problemDetails.setMessage(jpaObjectRetrievalFailureException.getMessage());
        return problemDetails;

    }
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
