package com.labmedicine.labmedicalapi.dtos;

import lombok.Getter;
import org.springframework.validation.FieldError;

@Getter
public class ValidationErrorDto {
    private final String field;
    private final String message;

    public ValidationErrorDto(FieldError error) {
        this.field = error.getField();
        this.message = error.getDefaultMessage();
    }
}
