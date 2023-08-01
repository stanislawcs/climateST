package com.example.climatest.code.dto;

import com.example.climatest.code.models.system.roles.UserRoles;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class EmployeeDTO {

    @NotEmpty(message = "Name should be not empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    @NotEmpty(message = "Email should be not empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "Username should be not empty")
    @Size(min = 4, max = 30,message = "Username should be between 4 and 30 characters")
    private String username;

    @NotEmpty(message = "Password should be not empty")
    @Size(min = 4, max = 20, message = "Password should be between 4 and 20 characters")
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRoles role = UserRoles.CLIENT;
}
