package com.example.climatest.code.converter;

import com.example.climatest.code.dto.CarDTO;
import com.example.climatest.code.models.Car;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public CarConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Car convertToCar(CarDTO carDTO){
      return modelMapper.map(carDTO,Car.class);
    }

    public CarDTO convertToDTO(Car car){
        return modelMapper.map(car,CarDTO.class);
    }

}
