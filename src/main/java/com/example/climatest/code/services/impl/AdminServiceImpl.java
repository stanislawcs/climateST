package com.example.climatest.code.services.impl;

import com.example.climatest.code.models.Employee;
import com.example.climatest.code.models.system.roles.UserRoles;
import com.example.climatest.code.services.AdminService;
import com.example.climatest.code.services.EmployeeService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final EmployeeService employeeService;

    @Override
    public void save(int id) {
        Employee employee = employeeService.getOne(id);
        employee.setRole(UserRoles.ROLE_ADMIN);
        employeeService.save(employee);
    }
}
