package com.example.climatest.code.services;

import com.example.climatest.code.models.Client;

public interface ClientService {
    void save(Client client);
    Client getOne(int id);
}
