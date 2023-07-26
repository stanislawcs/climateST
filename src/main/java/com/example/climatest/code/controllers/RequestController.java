package com.example.climatest.code.controllers;

import com.example.climatest.code.converter.RequestConverter;
import com.example.climatest.code.dto.RequestDTO;
import com.example.climatest.code.services.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/requests")
public class RequestController {

    private final RequestService requestService;
    private final RequestConverter requestConverter;

    @GetMapping()
    public List<RequestDTO> getAll() {
        return requestService.getAll().stream()
                .map(requestConverter::convertToDTO).collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody RequestDTO requestDTO) {

        requestService.save(requestConverter.convertToRequest(requestDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
