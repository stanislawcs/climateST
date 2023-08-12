package com.example.climatest.code.services.impl;

import com.example.climatest.code.converter.EmployeeConverter;
import com.example.climatest.code.models.Employee;
import com.example.climatest.code.repositories.EmployeeRepository;
import com.example.climatest.code.services.EmployeeService;
import com.example.climatest.code.util.exceptions.employee.EmployeeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeConverter employeeConverter;
    @Override
    public List<Employee> findAll() {
        log.info("GET: get all employees");
        return employeeRepository.findAll();
    }

    @Override
    public Employee getOne(int id) {
        log.info("GET: get one employee by id");
        Optional<Employee> foundEmployee = employeeRepository.findById(id);
        return foundEmployee.orElseThrow(() -> new EmployeeException("Employee not found"));
    }

    @Override
    public Optional<Employee> getOneByEmail(String email) {
        log.info("GET: get one employee by email");
        return employeeRepository.findEmployeeByEmail(email);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        log.info("POST: save one employee");
        employeeConverter.enrichEmployeeToSave(employee);
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void update(Employee employee, int id) {
        log.info("PATCH: update one employee");
        employee.setId(id);
        employee.setCreatedAt(getOne(id).getCreatedAt());
        employeeConverter.enrichEmployeeToUpdate(employee);
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        log.info("DELETE: delete one employee");
        employeeRepository.deleteById(id);
    }
}
