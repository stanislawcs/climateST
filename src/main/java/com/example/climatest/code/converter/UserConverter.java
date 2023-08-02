package com.example.climatest.code.converter;

import com.example.climatest.code.dto.EmployeeDTO;
import com.example.climatest.code.dto.UserDTO;
import com.example.climatest.code.models.Employee;
import com.example.climatest.code.models.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserConverter {

    private final ModelMapper modelMapper;

    public UserDTO convertToDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User convertToEmployee(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
