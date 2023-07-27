package com.example.climatest.code.services;

import com.example.climatest.code.models.Car;
import com.example.climatest.code.models.Employee;
import com.example.climatest.code.models.Request;
import com.example.climatest.code.repositories.RequestRepository;
import com.example.climatest.code.services.impl.RequestServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
public class RequestServiceTest {

    @InjectMocks
    private RequestServiceImpl requestService;

    @Mock
    private RequestRepository requestRepository;

    @Mock
    private EmployeeService employeeService;

    @Mock
    private CarService carService;

    private Employee employee;
    private Car car;

    @BeforeEach
    void createEmployeeAndCar() {
        employee = new Employee(1, "name", "email@gmail.com", Collections.emptyList());
        car = new Car(1, "mark", "number", Collections.emptyList());
    }

    @Test
    public void getAll_returnAllRequests() {
        Request request1 = new Request(1, employee, car);
        Request request2 = new Request(2, employee, car);

        Mockito.when(requestRepository.findAll()).thenReturn(List.of(request1, request2));

        List<Request> requests = requestService.getAll();

        Assertions.assertEquals(List.of(request1, request2), requests);
    }

    @Test
    public void save_saveOneRequest() {
        Request request = new Request(1, employee, car);
        Mockito.when(carService.getOneByNumber(request.getCar().getNumber())).thenReturn(Optional.of(car));
        Mockito.when(employeeService.getOneByEmail(request.getEmployee().getEmail())).thenReturn(Optional.of(employee));

        requestService.save(request);
        Mockito.verify(requestRepository).save(request);
    }

}

