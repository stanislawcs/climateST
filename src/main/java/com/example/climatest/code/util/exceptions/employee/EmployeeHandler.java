package com.example.climatest.code.util.exceptions.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class EmployeeHandler {

    @ExceptionHandler
    private ResponseEntity<EmployeeErrorResponse> handleException(EmployeeException e) {

        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse(e.getMessage(),
                LocalDateTime.now());

        return new ResponseEntity<>(employeeErrorResponse, HttpStatus.BAD_REQUEST);
    }

}
