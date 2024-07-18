package com.gurkangokmen.erp_project.exception;

public class SiparisPrimaryKeyCannotBeNegativeException extends RuntimeException {
    public SiparisPrimaryKeyCannotBeNegativeException(String message) {
        super(message);
    }

    public SiparisPrimaryKeyCannotBeNegativeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SiparisPrimaryKeyCannotBeNegativeException(Throwable cause) {
        super(cause);
    }
}
