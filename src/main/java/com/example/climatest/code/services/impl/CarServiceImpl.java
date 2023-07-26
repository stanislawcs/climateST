package com.example.climatest.code.services.impl;

import com.example.climatest.code.models.Car;
import com.example.climatest.code.repositories.CarRepository;
import com.example.climatest.code.services.CarService;
import com.example.climatest.code.util.exceptions.car.CarException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public Car getOneByNumber(String number) {
        return carRepository.findCarByNumber(number).orElseThrow(CarException::new);
    }
}
