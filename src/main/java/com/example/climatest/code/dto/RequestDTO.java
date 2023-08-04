package com.example.climatest.code.dto;

import com.example.climatest.code.dto.employee.EmployeeDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO {

    private EmployeeDTO employee;
    private CarDTO car;
}
