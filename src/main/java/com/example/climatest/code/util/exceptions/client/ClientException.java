package com.example.climatest.code.util.exceptions.client;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClientException extends RuntimeException{
    public ClientException(String message){
        super(message);
    }
}
