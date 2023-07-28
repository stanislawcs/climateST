package com.example.climatest.code.services.impl;

import com.example.climatest.code.models.Employee;
import com.example.climatest.code.repositories.EmployeeRepository;
import com.example.climatest.code.services.EmployeeService;
import com.example.climatest.code.util.exceptions.employee.EmployeeException;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final static Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);

    @Override
    public List<Employee> findAll() {
        logger.info("GET: get all employees");
        return employeeRepository.findAll();
    }

    @Override
    public Employee getOne(int id) {
        logger.info("GET: get one employee by id");
        Optional<Employee> foundEmployee = employeeRepository.findById(id);
        return foundEmployee.orElseThrow(()->new EmployeeException("Employee not found"));
    }

    @Override
    public Optional<Employee> getOneByEmail(String email) {
        logger.info("GET: get one employee by email");
        return employeeRepository.findEmployeeByEmail(email);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        logger.info("POST: save one employee");
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void update(Employee employee, int id) {
        logger.info("PUT: update one employee");
        employee.setId(id);
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        logger.info("DELETE: delete one employee");
        employeeRepository.deleteById(id);
    }
}
