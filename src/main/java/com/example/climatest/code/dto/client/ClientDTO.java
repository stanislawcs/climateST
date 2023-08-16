package com.example.climatest.code.dto.client;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ClientDTO {
    @NotEmpty(message = "Name should be not empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;
}
