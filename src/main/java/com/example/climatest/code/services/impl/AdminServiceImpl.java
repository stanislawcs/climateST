package com.example.climatest.code.services.impl;

import com.example.climatest.code.models.Employee;
import com.example.climatest.code.models.system.roles.UserRoles;
import com.example.climatest.code.repositories.EmployeeRepository;
import com.example.climatest.code.services.AdminService;
import com.example.climatest.code.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public void save(int id) {
        log.info("Create new admin from employee");
        Employee employee = employeeService.getOne(id);
        employee.setRole(UserRoles.ROLE_ADMIN);
        employeeRepository.save(employee);
    }
}
