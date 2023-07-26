package com.example.climatest.code.converter;

import com.example.climatest.code.dto.CarDTO;
import com.example.climatest.code.models.Car;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarConverter {

    private final ModelMapper modelMapper;

    public Car convertToCar(CarDTO carDTO) {
        return modelMapper.map(carDTO, Car.class);
    }

    public CarDTO convertToDTO(Car car) {
        return modelMapper.map(car, CarDTO.class);
    }

}
