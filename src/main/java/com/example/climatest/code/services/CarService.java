package com.example.climatest.code.services;

import com.example.climatest.code.models.Car;

import java.util.Optional;

public interface CarService {

    Optional<Car> getOneByNumber(String number);
}
