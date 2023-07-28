package com.example.climatest.code.services.impl;

import com.example.climatest.code.models.Car;
import com.example.climatest.code.repositories.CarRepository;
import com.example.climatest.code.services.CarService;
import com.example.climatest.code.util.exceptions.car.CarException;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final static Logger logger = LogManager.getLogger(CarServiceImpl.class);

    public Optional<Car> getOneByNumber(String number) {
        logger.info("GET: get one car by it's number");
        return carRepository.findCarByNumber(number);
    }
}
