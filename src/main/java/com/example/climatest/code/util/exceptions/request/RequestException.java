package com.example.climatest.code.util.exceptions.request;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RequestException extends RuntimeException{

    public RequestException(String message){
        super(message);
    }

}
