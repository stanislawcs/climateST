package com.example.climatest.code.security.services;

import com.example.climatest.code.models.User;
import com.example.climatest.code.repositories.UserRepository;
import com.example.climatest.code.security.details.Details;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> foundUser = userRepository.findByUsername(username);

        if (foundUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        }

        return new Details(foundUser.get());
    }
}
