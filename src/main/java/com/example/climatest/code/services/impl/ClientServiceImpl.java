package com.example.climatest.code.services.impl;

import com.example.climatest.code.models.Client;
import com.example.climatest.code.repositories.ClientRepository;
import com.example.climatest.code.services.ClientService;
import com.example.climatest.code.util.exceptions.client.ClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public void save(Client client) {
    clientRepository.save(client);
    }

    @Override
    public Client getOne(int id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(()->new ClientException("Client not found"));
    }
}
