package com.example.climatest.code.controllers;

import com.example.climatest.code.converter.EmployeeConverter;
import com.example.climatest.code.dto.EmployeeDTO;
import com.example.climatest.code.models.Employee;
import com.example.climatest.code.security.details.Details;
import com.example.climatest.code.security.util.JWTUtil;
import com.example.climatest.code.services.EmployeeService;
import com.example.climatest.code.services.UserService;
import com.example.climatest.code.util.errors.ErrorsUtil;
import com.example.climatest.code.util.exceptions.employee.EmployeeException;
import com.example.climatest.code.util.generator.UsernameAndPasswordGenerator;
import com.example.climatest.code.util.response.employee.EmployeeCreateResponse;
import com.example.climatest.code.util.validators.EmployeeValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeConverter employeeConverter;
    private final EmployeeService employeeService;
    private final EmployeeValidator employeeValidator;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtil jwtUtil;
    private final UserService userService;

    @GetMapping()
    public List<EmployeeDTO> getAll() {
        return employeeService.findAll().stream()
                .map(employeeConverter::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EmployeeDTO getOne(@PathVariable("id") int id) {
        return employeeConverter.convertToDTO(employeeService.getOne(id));
    }

    @GetMapping("profile")
    public String profile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Details userDetails = (Details) authentication.getPrincipal();


        return userDetails.getUsername();
    }

    @PostMapping()
    public ResponseEntity<EmployeeCreateResponse> registration(@RequestBody @Valid EmployeeDTO employeeDTO,
                                                               BindingResult bindingResult) {

        Employee employeeToSave = employeeConverter.convertToEmployee(employeeDTO);
        employeeValidator.validate(employeeToSave, bindingResult);

        if (bindingResult.hasErrors()) {
            String result = ErrorsUtil.getErrorsToClient(bindingResult);
            throw new EmployeeException(result);
        }

        String username = UsernameAndPasswordGenerator.generateUsername();
        String password = UsernameAndPasswordGenerator.generatePassword();

        EmployeeCreateResponse employeeCreateResponse
                = new EmployeeCreateResponse(HttpStatus.CREATED,
                username, password, jwtUtil.generateToken(username));

        employeeToSave.setUsername(username);
        employeeToSave.setPassword(passwordEncoder.encode(password));

        employeeService.save(employeeToSave);
        return new ResponseEntity<>(employeeCreateResponse, HttpStatus.CREATED);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid EmployeeDTO employeeDTO,
                                             BindingResult bindingResult,
                                             @PathVariable("id") int id) {

        Employee employee = employeeConverter.convertToEmployee(employeeDTO);
        employeeValidator.validate(employee, bindingResult);

        if (bindingResult.hasErrors()) {
            String result = ErrorsUtil.getErrorsToClient(bindingResult);
            throw new EmployeeException(result);
        }

        employeeService.update(employee,id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        employeeService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}