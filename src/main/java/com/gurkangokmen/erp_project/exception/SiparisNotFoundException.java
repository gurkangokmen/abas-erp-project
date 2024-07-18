package com.gurkangokmen.erp_project.exception;

public class SiparisNotFoundException extends RuntimeException {

        public SiparisNotFoundException() {
        }

        public SiparisNotFoundException(String message) {
            super(message);
        }

        public SiparisNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }

        public SiparisNotFoundException(Throwable cause) {
            super(cause);
        }

        public SiparisNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }

}
