package com.example.climatest.code.controllers;

import com.example.climatest.code.converter.RequestConverter;
import com.example.climatest.code.dto.RequestDTO;
import com.example.climatest.code.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
public class RequestController {

    private final RequestService requestService;
    private final RequestConverter requestConverter;

    @Autowired
    public RequestController(RequestService requestService,
                             RequestConverter requestConverter) {
        this.requestService = requestService;
        this.requestConverter = requestConverter;
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody RequestDTO requestDTO){

        requestService.save(requestConverter.convertToRequest(requestDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
