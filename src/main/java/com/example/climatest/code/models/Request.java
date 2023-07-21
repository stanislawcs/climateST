package com.example.climatest.code.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee", referencedColumnName = "name")
    @JsonBackReference
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "car",referencedColumnName = "number")
    @JsonBackReference
    private Car car;
}
