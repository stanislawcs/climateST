package com.example.climatest.code.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CarDTO {

    @NotEmpty(message = "Car mark should be not empty")
    @Size(min = 2, max = 30, message = "Car mark should be between 2 and 30 characters")
    private String mark;
    @NotEmpty(message = "Car number should be not empty")
    private String number;
}
