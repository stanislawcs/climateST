package com.example.climatest.code.services;

import com.example.climatest.code.models.Client;
import com.example.climatest.code.models.Employee;
import com.example.climatest.code.repositories.EmployeeRepository;
import com.example.climatest.code.services.impl.EmployeeServiceImpl;
import com.example.climatest.code.util.exceptions.employee.EmployeeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    void getAll_getAllEmployees() {
        Employee employee1 = new Employee("shukans588@gmail.com", Collections.emptyList());
        Employee employee2 = new Employee("shukans538@gmail.com", Collections.emptyList());
        Mockito.when(employeeRepository.findAll()).thenReturn(List.of(employee1, employee2));

        List<Employee> employees = employeeService.findAll();

        Assertions.assertEquals(List.of(employee1, employee2), employees);
    }

    @Test
    void getOneByEmail_returnEmployee() {
        String email = "shukans588@gmail.com";
        Employee employee = new Employee(email, Collections.emptyList());
        Mockito.when(employeeRepository.findEmployeeByEmail(email)).thenReturn(Optional.of(employee));

        Employee empl = employeeService.getOneByEmail(email).orElseThrow();
        Assertions.assertEquals(employee, empl);
    }


    @Test
    void getOne_positiveWay_returnEmployee() {
        int id = 1;
        Employee employee = new Employee("shukans588@gmail.com", Collections.emptyList());
        Mockito.when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));

        Employee empl = employeeService.getOne(id);
        Assertions.assertEquals(employee, empl);
    }

    @Test
    void getOne_negativeWay_throwEx() {
        int id = 1;
        Mockito.when(employeeRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(EmployeeException.class, () -> employeeService.getOne(id));
    }

    @Test
    void delete_removeEmployee() {
        Employee employee = new Employee("shukans588@gmail.com", Collections.emptyList());
        employeeService.delete(employee.getId());
        Mockito.verify(employeeRepository).deleteById(employee.getId());
    }


}
