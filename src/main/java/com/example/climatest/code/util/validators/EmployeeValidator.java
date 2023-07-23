package com.example.climatest.code.util.validators;

import com.example.climatest.code.models.Employee;
import com.example.climatest.code.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeValidator(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        if (employeeService.getOneByEmail(employee.getEmail()) != null) {
            errors.rejectValue("email", HttpStatus.BAD_REQUEST.toString(), "This email is already taken");
        }
    }
}
