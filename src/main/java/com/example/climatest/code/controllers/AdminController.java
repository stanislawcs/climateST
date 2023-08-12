package com.example.climatest.code.controllers;

import com.example.climatest.code.security.util.JWTUtil;
import com.example.climatest.code.services.AdminService;
import com.example.climatest.code.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final JWTUtil jwtUtil;
    private final EmployeeService employeeService;

    @PostMapping("/{id}")
    public ResponseEntity<String> add(@PathVariable("id") int id) {
        adminService.save(id);
        return new ResponseEntity<>(jwtUtil.generateToken(employeeService.getOne(id).getUsername()), HttpStatus.OK);
    }

}
