package com.example.climatest.code.controllers;

import com.example.climatest.code.converter.ClientConverter;
import com.example.climatest.code.dto.client.ClientCreateDTO;
import com.example.climatest.code.dto.client.ClientDTO;
import com.example.climatest.code.models.Client;
import com.example.climatest.code.security.util.JWTUtil;
import com.example.climatest.code.services.ClientService;
import com.example.climatest.code.util.errors.ErrorsUtil;
import com.example.climatest.code.util.exceptions.client.ClientException;
import com.example.climatest.code.util.response.client.ClientCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final JWTUtil jwtUtil;
    private final ClientService clientService;
    private final ClientConverter clientConverter;

    @GetMapping()
    public List<ClientDTO> getAll(){
        return clientService.getAll().stream().map(clientConverter::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ClientDTO getOne(@PathVariable("id") int id) {
        return clientConverter.convertToDTO(clientService.getOne(id));
    }

    @PostMapping()
    public ResponseEntity<ClientCreateResponse> register(@RequestBody @Valid ClientCreateDTO clientCreateDTO,
                                               BindingResult bindingResult) {

        Client clientToSave = clientConverter.convertToClient(clientCreateDTO);
        if (bindingResult.hasErrors()) {
            String result = ErrorsUtil.getErrorsToClient(bindingResult);
            throw new ClientException(result);
        }

        String token = jwtUtil.generateToken(clientToSave.getUsername());
        ClientCreateResponse clientCreateResponse
                = new ClientCreateResponse(token,HttpStatus.CREATED);

        clientService.save(clientToSave);
        return new ResponseEntity<>(clientCreateResponse,HttpStatus.CREATED);
    }



}
