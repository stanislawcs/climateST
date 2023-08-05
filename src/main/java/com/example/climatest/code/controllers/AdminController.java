package com.example.climatest.code.controllers;

import com.example.climatest.code.models.Employee;
import com.example.climatest.code.models.system.roles.UserRoles;
import com.example.climatest.code.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final EmployeeService employeeService;

    @Autowired
    public AdminController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<HttpStatus> add(@PathVariable("id") int id){
        Employee employee = employeeService.getOne(id);
        employee.setRole(UserRoles.ADMIN);
        employeeService.save(employee);
        return ResponseEntity.ok(HttpStatus.OK);
    }



}
