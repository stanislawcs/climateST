package com.example.climatest.code.services.impl;

import com.example.climatest.code.models.Employee;
import com.example.climatest.code.repositories.EmployeeRepository;
import com.example.climatest.code.services.EmployeeService;
import com.example.climatest.code.util.exceptions.employee.EmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getOne(int id) {
        Optional<Employee> foundEmployee = employeeRepository.findById(id);
        return foundEmployee.orElseThrow(EmployeeException::new);
    }

    @Override
    public Employee getOneByEmail(String email) {
        return employeeRepository.findEmployeeByEmail(email);
    }

    @Transactional
    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void update(Employee employee, int id) {
        employee.setId(id);
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
