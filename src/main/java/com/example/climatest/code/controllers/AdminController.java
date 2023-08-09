package com.example.climatest.code.controllers;

import com.example.climatest.code.services.AdminService;
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

    @PostMapping("/{id}")
    public ResponseEntity<HttpStatus> add(@PathVariable("id") int id) {
        adminService.save(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
