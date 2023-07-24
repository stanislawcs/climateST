package com.example.climatest.code.services.impl;

import com.example.climatest.code.models.Request;
import com.example.climatest.code.repositories.CarRepository;
import com.example.climatest.code.repositories.EmployeeRepository;
import com.example.climatest.code.repositories.RequestRepository;
import com.example.climatest.code.services.CarService;
import com.example.climatest.code.services.EmployeeService;
import com.example.climatest.code.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;
    private final EmployeeService employeeService;
    private final CarService carService;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository, EmployeeService employeeService,CarService carService) {
        this.requestRepository = requestRepository;
        this.employeeService = employeeService;
        this.carService = carService;
    }

    @Override
    @Transactional
    public void save(Request request) {
        request.setEmployee(employeeService.getOneByEmail(request.getEmployee().getEmail()));
        request.setCar(carService.getOneByNumber(request.getCar().getNumber()));
        requestRepository.save(request);
    }

}
