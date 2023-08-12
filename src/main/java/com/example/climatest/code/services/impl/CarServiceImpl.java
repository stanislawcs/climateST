package com.example.climatest.code.services.impl;

import com.example.climatest.code.models.Car;
import com.example.climatest.code.repositories.CarRepository;
import com.example.climatest.code.services.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;


    public Optional<Car> getOneByNumber(String number) {
        log.info("GET: get one car by it's number");
        return carRepository.findCarByNumber(number);
    }
}
