package com.example.climatest.code.controllers;

import com.example.climatest.code.dto.AuthDTO;
import com.example.climatest.code.security.details.Details;
import com.example.climatest.code.security.util.JWTUtil;
import com.example.climatest.code.util.response.jwt.JWTResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    @PostMapping("/auth/login")
    public ResponseEntity<JWTResponse> login(@RequestBody AuthDTO userDTO) {

        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword());
        authenticationManager.authenticate(authInputToken);

        JWTResponse jwt = new JWTResponse(jwtUtil.generateToken(userDTO.getUsername()));
        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }

    @GetMapping("profile")
    public String profile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Details userDetails = (Details) authentication.getPrincipal();
        return userDetails.getUsername();
    }
}

