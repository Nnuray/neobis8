package com.example.neobis8.service;

import com.example.neobis8.dto.auth.AuthenticationRequest;
import com.example.neobis8.dto.auth.AuthenticationResponse;
import com.example.neobis8.dto.auth.RegisterRequest;
import com.example.neobis8.entity.User;
import com.example.neobis8.enums.Role;
import com.example.neobis8.jwt.JwtService;
import com.example.neobis8.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register (RegisterRequest request) {
        if(repository.existByEmail(request.getEmail())){
            throw new IllegalArgumentException("Already exists");
        }
        var user = User.builder()
                .email((request.getEmail()))
                .username(request.getUsername())
                .firstName(request.getFirst_name())
                .lastName(request.getLast_name())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.Customer)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
