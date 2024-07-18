package com.gurkangokmen.erp_project.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MalErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
