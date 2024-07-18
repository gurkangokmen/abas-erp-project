package com.gurkangokmen.erp_project.exception;

public class MalPrimaryKeyCannotBeNegativeException extends RuntimeException{
    public MalPrimaryKeyCannotBeNegativeException() {
    }

    public MalPrimaryKeyCannotBeNegativeException(String message) {
        super(message);
    }

    public MalPrimaryKeyCannotBeNegativeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MalPrimaryKeyCannotBeNegativeException(Throwable cause) {
        super(cause);
    }

    public MalPrimaryKeyCannotBeNegativeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
