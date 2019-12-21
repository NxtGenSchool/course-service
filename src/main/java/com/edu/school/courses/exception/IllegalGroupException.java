package com.edu.school.courses.exception;

public class IllegalGroupException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String errorMessage;

    public IllegalGroupException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = "";
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
