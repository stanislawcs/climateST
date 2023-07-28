package com.example.climatest.code.util.exceptions.controller;

import com.example.climatest.code.util.exceptions.car.CarErrorResponse;
import com.example.climatest.code.util.exceptions.car.CarException;
import com.example.climatest.code.util.exceptions.employee.EmployeeErrorResponse;
import com.example.climatest.code.util.exceptions.employee.EmployeeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static com.example.climatest.code.util.errors.ExceptionStatusCode.ILLEGAL_CAR_CREDENTIALS;
import static com.example.climatest.code.util.errors.ExceptionStatusCode.ILLEGAL_EMPLOYEE_CREDENTIALS;

@RestControllerAdvice
public class Handler {

    private final static Logger logger = LogManager.getLogger(Handler.class);

    @ExceptionHandler
    private ResponseEntity<EmployeeErrorResponse> handleEmployeeException(EmployeeException e) {

        logger.error("EmployeeException: " + e.getMessage());
        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse(e.getMessage(),
                LocalDateTime.now(), ILLEGAL_EMPLOYEE_CREDENTIALS.getStatusCode());

        return new ResponseEntity<>(employeeErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<CarErrorResponse> handleCarException(CarException e) {

        logger.error("CarException: " + e.getMessage());
        CarErrorResponse carErrorResponse = new CarErrorResponse(e.getMessage(),
                LocalDateTime.now(), ILLEGAL_CAR_CREDENTIALS.getStatusCode());

        return new ResponseEntity<>(carErrorResponse, HttpStatus.BAD_REQUEST);
    }


}
