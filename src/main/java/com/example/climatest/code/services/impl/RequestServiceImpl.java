package com.example.climatest.code.services.impl;

import com.example.climatest.code.models.Request;
import com.example.climatest.code.repositories.RequestRepository;
import com.example.climatest.code.services.CarService;
import com.example.climatest.code.services.EmployeeService;
import com.example.climatest.code.services.RequestService;
import lombok.RequiredArgsConstructor;
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


    @Override
    public List<Request> getAll() {
        return requestRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Request request) {
        request.setEmployee(employeeService.getOneByEmail(request.getEmployee().getEmail()));
        request.setCar(carService.getOneByNumber(request.getCar().getNumber()));
        requestRepository.save(request);
    }

}
