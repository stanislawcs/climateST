package com.example.climatest.code.services.impl;

import com.example.climatest.code.models.Request;
import com.example.climatest.code.repositories.RequestRepository;
import com.example.climatest.code.services.CarService;
import com.example.climatest.code.services.EmployeeService;
import com.example.climatest.code.services.RequestService;
import com.example.climatest.code.util.exceptions.car.CarException;
import com.example.climatest.code.util.exceptions.employee.EmployeeException;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RequestServiceImpl implements RequestService {

    private final CarService carService;
    private final EmployeeService employeeService;
    private final RequestRepository requestRepository;
    private final Logger logger = LogManager.getLogger(RequestServiceImpl.class);


    @Override
    public List<Request> getAll() {
        logger.info("GET: get all request");
        return requestRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Request request) {
        logger.info("1. get one employee by email to check: this employee exist or not");
        request.setEmployee(employeeService
                .getOneByEmail(request.getEmployee().getEmail())
                .orElseThrow(() -> new EmployeeException("Employee with this email not found")));

        logger.info("2. get one car by number to check: this car exist or not");
        request.setCar(carService
                .getOneByNumber(request.getCar().getNumber())
                .orElseThrow(() -> new CarException("Car with this number not found")));

        logger.info("PUT: save one request");
        requestRepository.save(request);
    }

}
