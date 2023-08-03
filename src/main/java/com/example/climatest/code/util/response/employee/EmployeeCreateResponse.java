package com.example.climatest.code.util.response.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class EmployeeCreateResponse {
    private HttpStatus status;
    private String username;
    private String password;
    private String jwt;
}

