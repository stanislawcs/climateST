package com.example.climatest.code.controllers;

import com.example.climatest.code.converter.EmployeeConverter;
import com.example.climatest.code.dto.EmployeeDTO;
import com.example.climatest.code.models.Employee;
import com.example.climatest.code.services.EmployeeService;
import com.example.climatest.code.util.exceptions.employee.EmployeeException;
import com.example.climatest.code.util.validators.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeConverter employeeConverter;
    private final EmployeeService employeeService;
    private final EmployeeValidator employeeValidator;

    @Autowired
    public EmployeeController(

            EmployeeConverter employeeConverter,
            EmployeeService employeeService,
            EmployeeValidator employeeValidator) {

        this.employeeConverter = employeeConverter;
        this.employeeService = employeeService;
        this.employeeValidator = employeeValidator;
    }

    @GetMapping()
    public List<EmployeeDTO> getAll() {
        return employeeService.findAll().stream()
                .map(employeeConverter::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EmployeeDTO getOne(@PathVariable("id") int id) {
        return employeeConverter.convertToDTO(employeeService.getOne(id));
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid EmployeeDTO employeeDTO,
                                                   BindingResult bindingResult) {

        Employee employeeToSave = employeeConverter.convertToEmployee(employeeDTO);

        employeeValidator.validate(employeeToSave, bindingResult);

        if (bindingResult.hasErrors()) {
            StringBuilder result = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();

            for (FieldError e : errors) {
                result.append(e.getField()).append("-")
                        .append(e.getDefaultMessage()).append(";");
            }

            throw new EmployeeException(result.toString());
        }

        employeeService.save(employeeToSave);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid EmployeeDTO employeeDTO,
                                             BindingResult bindingResult,
                                             @PathVariable("id") int id) {

        Employee employee = employeeConverter.convertToEmployee(employeeDTO);

        employeeValidator.validate(employee, bindingResult);

        if (bindingResult.hasErrors()) {
            StringBuilder result = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();

            for (FieldError e : errors) {
                result.append(e.getField()).append("-")
                        .append(e.getDefaultMessage()).append(";");
            }

            throw new EmployeeException(result.toString());
        }

        employeeService.update(employee, id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        employeeService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}