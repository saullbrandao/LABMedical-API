package com.labmedicine.labmedicalapi.controllers;

import com.labmedicine.labmedicalapi.exceptions.dto.RuntimeExceptionDto;
import com.labmedicine.labmedicalapi.exceptions.NotFoundException;
import com.labmedicine.labmedicalapi.exceptions.PatientHasExamsException;
import com.labmedicine.labmedicalapi.exceptions.dto.ValidationErrorExceptionDto;
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
    public ResponseEntity<List<ValidationErrorExceptionDto>> validationError(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(
                errors.stream().map(ValidationErrorExceptionDto::new).collect(Collectors.toList()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<RuntimeExceptionDto> notFoundError(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RuntimeExceptionDto(ex));
    }

    @ExceptionHandler(PatientHasExamsException.class)
    public ResponseEntity<RuntimeExceptionDto> patientHasExams(PatientHasExamsException ex) {
        return ResponseEntity.badRequest().body(new RuntimeExceptionDto(ex));
    }
}
