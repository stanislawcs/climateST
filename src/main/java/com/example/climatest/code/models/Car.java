package com.example.climatest.code.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cars")
@NoArgsConstructor
public class Car implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "mark")
    @NotEmpty(message = "Car mark should be not empty")
    @Size(min = 2, max = 30, message = "Car mark should be between 2 and 30 characters")
    private String mark;

    @Column(name = "number")
    @NotEmpty(message = "Car number should be not empty")
    private String number;

    @OneToMany(mappedBy = "car")
    @JsonManagedReference
    private List<Request> requests;
}
