package com.example.climatest.code.services;

import com.example.climatest.code.models.Request;

import java.util.List;


public interface RequestService {

    void save(Request request);

    List<Request> getAll();
}
