package com.gurkangokmen.erp_project.exception;

public class MalNotFoundException extends RuntimeException{

    public MalNotFoundException() {
    }

    public MalNotFoundException(String message) {
        super(message);
    }

    public MalNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MalNotFoundException(Throwable cause) {
        super(cause);
    }

    public MalNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
