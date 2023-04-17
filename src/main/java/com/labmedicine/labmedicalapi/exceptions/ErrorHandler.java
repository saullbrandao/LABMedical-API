package com.labmedicine.labmedicalapi.exceptions;

import com.labmedicine.labmedicalapi.dtos.ValidationErrorDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorDto>> validationError(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(
                errors.stream().map(ValidationErrorDto::new).collect(Collectors.toList()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<NotFoundException> notFoundError() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFoundException("Not Found"));
    }
}
