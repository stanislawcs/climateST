package com.example.climatest.code.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends User implements Serializable {

    @Column(name = "email")
    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email should be not empty")
    private String email;

    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
    private List<Request> requests;
}