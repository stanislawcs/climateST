package com.example.climatest.code.services;

import com.example.climatest.code.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    void save(Employee employee);
    Employee getOne(int id);
    Employee getOneByEmail(String email);
}
