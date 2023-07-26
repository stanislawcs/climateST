package com.example.climatest.code.util.exceptions.car;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CarException extends RuntimeException{

    public CarException(String message) {
        super(message);
    }

}
