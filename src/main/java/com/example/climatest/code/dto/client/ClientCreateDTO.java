package com.example.climatest.code.dto.client;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ClientCreateDTO extends ClientDTO{

    @NotEmpty(message = "Username should be not empty")
    @Size(min = 4, max = 30, message = "Username should be between 4 and 30 characters")
    private String username;
    @NotEmpty(message = "Password should be not empty")
    private String password;

}
