package com.example.climatest.code.models;

import com.example.climatest.code.models.system.roles.UserRoles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private int id;

    @NotEmpty(message = "Username should be not empty")
    @Column(name = "username")
    @Size(min = 4, max = 30, message = "Username should be between 4 and 30 characters")
    private String username;

    @NotEmpty(message = "Password should be not empty")
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRoles role;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @NotEmpty(message = "Name should be not empty")
    @Column(name = "name")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;
}
