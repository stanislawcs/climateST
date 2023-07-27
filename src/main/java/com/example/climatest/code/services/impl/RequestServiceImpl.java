package com.example.climatest.code.services.impl;

import com.example.climatest.code.models.Employee;
import com.example.climatest.code.models.Request;
import com.example.climatest.code.repositories.RequestRepository;
import com.example.climatest.code.services.CarService;
import com.example.climatest.code.services.EmployeeService;
import com.example.climatest.code.services.RequestService;
import com.example.climatest.code.util.exceptions.car.CarException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RequestServiceImpl implements RequestService {

    private final CarService carService;
    private final EmployeeService employeeService;
    private final RequestRepository requestRepository;


    @Override
    public List<Request> getAll() {
        return requestRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Request request) {
        Optional<Employee> employee = employeeService.getOneByEmail(request.getEmployee().getEmail());
        employee.ifPresent(request::setEmployee);

        request.setCar(carService.getOneByNumber(request.getCar().getNumber()).orElseThrow(CarException::new));
        requestRepository.save(request);
    }

}
