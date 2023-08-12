package com.example.climatest.code.converter;

import com.example.climatest.code.dto.employee.EmployeeDTO;
import com.example.climatest.code.models.Employee;
import com.example.climatest.code.models.system.roles.UserRoles;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class EmployeeConverter {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public EmployeeDTO convertToDTO(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public Employee convertToEmployee(EmployeeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, Employee.class);
    }

    public void enrichEmployeeToSave(Employee employee) {
        employee.setRole(UserRoles.ROLE_EMPLOYEE);
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employee.setCreatedAt(new Date());
        employee.setUpdatedAt(employee.getCreatedAt());
    }

    public void enrichEmployeeToUpdate(Employee employee){
        employee.setRole(UserRoles.ROLE_EMPLOYEE);
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employee.setUpdatedAt(new Date());
    }
}
