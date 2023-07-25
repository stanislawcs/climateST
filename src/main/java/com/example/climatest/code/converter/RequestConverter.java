package com.example.climatest.code.converter;

import com.example.climatest.code.dto.RequestDTO;
import com.example.climatest.code.models.Request;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestConverter {


    private final ModelMapper modelMapper;

    @Autowired
    public RequestConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Request convertToRequest(RequestDTO requestDTO) {
        return modelMapper.map(requestDTO, Request.class);
    }

    public RequestDTO convertToDTO(Request request){
        return modelMapper.map(request,RequestDTO.class);
    }
}
