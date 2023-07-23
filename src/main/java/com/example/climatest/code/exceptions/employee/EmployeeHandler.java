package com.example.climatest.code.exceptions.employee;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@ControllerAdvice
@RequestMapping("/employees")
public class EmployeeHandler {

    @ExceptionHandler
    private ResponseEntity<EmployeeErrorResponse> handleException(EmployeeException e){

        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse(e.getMessage(),
                                                                            LocalDateTime.now());

        return new ResponseEntity<>(employeeErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
