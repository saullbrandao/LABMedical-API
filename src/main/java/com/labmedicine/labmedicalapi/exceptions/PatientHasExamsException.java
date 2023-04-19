package com.labmedicine.labmedicalapi.exceptions;

public class PatientHasExamsException extends RuntimeException {
    public PatientHasExamsException() {
        super("Patient has at least one exam registered.");
    }
}
