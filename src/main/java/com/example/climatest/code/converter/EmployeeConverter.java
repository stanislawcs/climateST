package com.example.climatest.code.converter;

import com.example.climatest.code.dto.EmployeeDTO;
import com.example.climatest.code.models.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO convertToDTO(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public Employee convertToEmployee(EmployeeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, Employee.class);
    }
}
