package com.example.climatest.code.models;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
@NoArgsConstructor
public class Client extends User {
}
