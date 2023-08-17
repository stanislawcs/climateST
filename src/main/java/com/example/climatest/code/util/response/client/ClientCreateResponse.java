package com.example.climatest.code.util.response.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ClientCreateResponse {
    private String jwt;
    private HttpStatus status;
}
