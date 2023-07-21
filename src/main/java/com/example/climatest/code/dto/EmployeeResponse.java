package com.example.climatest.code.dto;

import java.util.List;

public class EmployeeResponse {
    private List<String> names;

    public EmployeeResponse(List<String> names){
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}