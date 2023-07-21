package com.example.climatest.code.controllers;

import com.example.climatest.code.dto.EmployeeDTO;
import com.example.climatest.code.dto.EmployeeResponse;
import com.example.climatest.code.models.Employee;
import com.example.climatest.code.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final ModelMapper modelMapper;
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(ModelMapper modelMapper,
                              EmployeeService employeeService) {
        this.modelMapper = modelMapper;
        this.employeeService = employeeService;
    }

    @GetMapping()
    public EmployeeResponse getAll() {
        return new EmployeeResponse(employeeService.findAll().stream()
                .map(Employee::getName).collect(Collectors.toList()));
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> registration(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.save(convertToEmployee(employeeDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    //TODO: Read about converter, it's had sense??
    private EmployeeDTO convertToDTO(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    private Employee convertToEmployee(EmployeeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, Employee.class);
    }


}

