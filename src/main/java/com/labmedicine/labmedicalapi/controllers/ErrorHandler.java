package com.labmedicine.labmedicalapi.controllers;

import com.labmedicine.labmedicalapi.exceptions.NotFoundException;
import com.labmedicine.labmedicalapi.exceptions.ValidationErrorException;
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
    public ResponseEntity<List<ValidationErrorException>> validationError(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(
                errors.stream().map(ValidationErrorException::new).collect(Collectors.toList()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<NotFoundException> notFoundError(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFoundException(ex.getMessage()));
    }
}
