package com.example.climatest.code.services.impl;

import com.example.climatest.code.models.Car;
import com.example.climatest.code.repositories.CarRepository;
import com.example.climatest.code.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getOneByNumber(String number){
        return carRepository.findCarByNumber(number);
    }
}