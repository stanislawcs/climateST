package com.example.climatest.code.services.impl;

import com.example.climatest.code.models.User;
import com.example.climatest.code.repositories.UserRepository;
import com.example.climatest.code.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void update(User user, int id){
        user.setId(id);
        userRepository.save(user);
    }
}
