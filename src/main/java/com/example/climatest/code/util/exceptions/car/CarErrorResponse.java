package com.example.climatest.code.util.exceptions.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CarErrorResponse {

    private String message;
    private LocalDateTime date;
    private int code;

}
