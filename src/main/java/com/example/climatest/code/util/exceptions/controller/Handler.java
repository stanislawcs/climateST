package com.example.climatest.code.util.exceptions.controller;

import com.example.climatest.code.util.exceptions.car.CarErrorResponse;
import com.example.climatest.code.util.exceptions.car.CarException;
import com.example.climatest.code.util.exceptions.client.ClientErrorResponse;
import com.example.climatest.code.util.exceptions.client.ClientException;
import com.example.climatest.code.util.exceptions.employee.EmployeeErrorResponse;
import com.example.climatest.code.util.exceptions.employee.EmployeeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static com.example.climatest.code.util.errors.ExceptionStatusCode.*;

@Slf4j
@RestControllerAdvice
public class Handler {

    @ExceptionHandler
    private ResponseEntity<EmployeeErrorResponse> handleEmployeeException(EmployeeException e) {

        log.error("EmployeeException: " + e.getMessage());
        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse(e.getMessage(),
                LocalDateTime.now(), ILLEGAL_EMPLOYEE_INFO.getStatusCode());

        return new ResponseEntity<>(employeeErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<CarErrorResponse> handleCarException(CarException e) {

        log.error("CarException: " + e.getMessage());
        CarErrorResponse carErrorResponse = new CarErrorResponse(e.getMessage(),
                LocalDateTime.now(), ILLEGAL_CAR_INFO.getStatusCode());

        return new ResponseEntity<>(carErrorResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler
    private ResponseEntity<ClientErrorResponse> handleClientException(ClientException e){
        log.error("ClientException: " + e.getMessage());
        ClientErrorResponse clientErrorResponse = new ClientErrorResponse(e.getMessage(),
                LocalDateTime.now(),ILLEGAL_CLIENT_INFO.getStatusCode());

        return new ResponseEntity<>(clientErrorResponse,HttpStatus.BAD_REQUEST);
    }

}
