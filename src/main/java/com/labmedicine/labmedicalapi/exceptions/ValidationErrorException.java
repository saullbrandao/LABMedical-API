package com.labmedicine.labmedicalapi.exceptions;

import lombok.Getter;
import org.springframework.validation.FieldError;

@Getter
public class ValidationErrorException {
    private final String field;
    private final String message;

    public ValidationErrorException(FieldError error) {
        this.field = error.getField();
        this.message = error.getDefaultMessage();
    }
}
