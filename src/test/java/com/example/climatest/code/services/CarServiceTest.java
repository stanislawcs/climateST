package com.example.climatest.code.services;

import com.example.climatest.code.models.Car;
import com.example.climatest.code.repositories.CarRepository;
import com.example.climatest.code.services.impl.CarServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    private String number;
    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarServiceImpl carService;


    @BeforeEach
    public void number() {
        number = "А782ВМ77";
    }

    @Test
    void getOneByNumber_positiveWay_getCar() {
        Car car = new Car(1, "Hyundai", number, Collections.emptyList());
        Mockito.when(carRepository.findCarByNumber(number)).thenReturn(Optional.of(car));

        Car expectedCar = carService.getOneByNumber(number).get();
        Assertions.assertEquals(expectedCar, car);
    }
}
