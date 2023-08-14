package com.example.climatest.code.util.exceptions.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ClientErrorResponse {

    private String message;
    private LocalDateTime date;
    private int code;

}
