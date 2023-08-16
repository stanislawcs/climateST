package com.example.climatest.code.controllers;

import com.example.climatest.code.converter.ClientConverter;
import com.example.climatest.code.dto.client.ClientCreateDTO;
import com.example.climatest.code.dto.client.ClientDTO;
import com.example.climatest.code.models.Client;
import com.example.climatest.code.services.ClientService;
import com.example.climatest.code.util.errors.ErrorsUtil;
import com.example.climatest.code.util.exceptions.client.ClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;
    private final ClientConverter clientConverter;

    @GetMapping("/{id}")
    public ClientDTO getOne(@PathVariable("id") int id){
       return clientConverter.convertToDTO(clientService.getOne(id));
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> register(@RequestBody @Valid ClientDTO clientDTO,
                                               BindingResult bindingResult){

        Client clientToSave = clientConverter.convertToClient(clientDTO);
        if(bindingResult.hasErrors()){
            String result = ErrorsUtil.getErrorsToClient(bindingResult);
            throw new ClientException(result);
        }

        clientService.save(clientToSave);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
