package com.example.climatest.code.services;

import com.example.climatest.code.models.Client;

import java.util.List;

public interface ClientService {
    void save(Client client);
    Client getOne(int id);
    List<Client> getAll();
}
