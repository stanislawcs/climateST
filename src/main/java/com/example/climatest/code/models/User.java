package com.example.climatest.code.models;

import com.example.climatest.code.models.system.roles.UserRoles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public class User {

    @NotEmpty(message = "Username should be not empty")
    @Size(min = 4, max = 30, message = "Username should be between 4 and 30 characters")
    private String username;

    @NotEmpty(message = "Password should be not empty")
    @Size(min = 4, max = 20, message = "Password should be between 4 and 20 characters")
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRoles role;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @NotEmpty(message = "Name should be not empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;
}
