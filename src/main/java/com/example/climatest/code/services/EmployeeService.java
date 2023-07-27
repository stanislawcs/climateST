package com.example.climatest.code.services;

import com.example.climatest.code.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();

    void save(Employee employee);

    Employee getOne(int id);

    Optional<Employee> getOneByEmail(String email);

    void update(Employee employee, int id);

    void delete(int id);
}
