package com.labmedicine.labmedicalapi.exceptions;

public class NotFoundException {
    private final String message;

    public NotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
