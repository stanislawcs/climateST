package com.example.climatest.code.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "request")
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee", referencedColumnName = "email")
    @JsonBackReference
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "car", referencedColumnName = "number")
    @JsonBackReference
    private Car car;

}

