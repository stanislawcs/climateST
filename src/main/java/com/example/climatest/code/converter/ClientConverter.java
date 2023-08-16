package com.example.climatest.code.converter;

import com.example.climatest.code.dto.client.ClientCreateDTO;
import com.example.climatest.code.dto.client.ClientDTO;
import com.example.climatest.code.models.Client;
import com.example.climatest.code.models.system.roles.UserRoles;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class ClientConverter {
    private final ModelMapper modelMapper;

    public Client convertToClient(ClientDTO clientDTO){
        return modelMapper.map(clientDTO,Client.class);
    }

    public ClientDTO convertToDTO(Client client){
        return modelMapper.map(client, ClientDTO.class);
    }

    public void enrichClientToSave(Client client){
        client.setCreatedAt(new Date());
        client.setRole(UserRoles.ROLE_CLIENT);
        client.setUpdatedAt(client.getCreatedAt());
    }
}
