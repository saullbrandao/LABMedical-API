package com.labmedicine.labmedicalapi.exceptions;

public class PatientHasAppointmentsException extends RuntimeException {
    public PatientHasAppointmentsException() {
        super("Patient has at least one appointment registered.");
    }
}
