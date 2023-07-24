package com.example.climatest.code.converter;

import com.example.climatest.code.dto.RequestDTO;
import com.example.climatest.code.models.Car;
import com.example.climatest.code.models.Employee;
import com.example.climatest.code.models.Request;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestConverter {

    private final EmployeeConverter employeeConverter;
    private final CarConverter carConverter;
    private final ModelMapper modelMapper;

    @Autowired
    public RequestConverter(EmployeeConverter employeeConverter,
                            CarConverter carConverter, ModelMapper modelMapper) {
        this.employeeConverter = employeeConverter;
        this.carConverter = carConverter;
        this.modelMapper = modelMapper;
    }

    public Request convertToRequest(RequestDTO requestDTO) {
        Employee employee = employeeConverter.convertToEmployee(requestDTO.getEmployee());
        Car car = carConverter.convertToCar(requestDTO.getCar());
        Request request = modelMapper.map(requestDTO,Request.class);
        request.setCar(car);
        request.setEmployee(employee);
        return request;
    }
}
