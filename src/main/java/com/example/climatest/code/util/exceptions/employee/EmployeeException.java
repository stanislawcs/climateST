package com.example.climatest.code.util.exceptions.employee;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmployeeException extends RuntimeException {

    public EmployeeException(String message) {
        super(message);
    }
}
