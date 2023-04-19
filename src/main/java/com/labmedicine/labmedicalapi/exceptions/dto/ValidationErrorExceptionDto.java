package com.labmedicine.labmedicalapi.exceptions.dto;

import lombok.Getter;
import org.springframework.validation.FieldError;

@Getter
public class ValidationErrorExceptionDto {
    private final String field;
    private final String message;

    public ValidationErrorExceptionDto(FieldError error) {
        this.field = error.getField();
        this.message = error.getDefaultMessage();
    }
}
