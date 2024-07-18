package com.gurkangokmen.erp_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MalRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<MalErrorResponse> handleDoctorNotFoundException(MalNotFoundException exc){
        MalErrorResponse malErrorResponse = new MalErrorResponse();
        malErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        malErrorResponse.setMessage(exc.getMessage());
        malErrorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(malErrorResponse,HttpStatus.NOT_FOUND);
    }
}
