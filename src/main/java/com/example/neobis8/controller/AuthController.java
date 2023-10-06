package com.example.neobis8.controller;

import com.example.neobis8.dto.auth.AuthRequestDTO;
import com.example.neobis8.dto.auth.AuthResponseDTO;
import com.example.neobis8.dto.auth.PasswordValidator;
import com.example.neobis8.dto.user.RequestUserDTO;
import com.example.neobis8.exception.PasswordValidationException;
import com.example.neobis8.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthController {
    AuthenticationService authenticationService;

    @PostMapping("/register")
    public AuthResponseDTO register(@Valid @RequestBody RequestUserDTO userDTO) {
        if (!PasswordValidator.isValidPassword(userDTO.getPassword())){
            throw new PasswordValidationException("Invalid password");
        }
        return authenticationService.register(userDTO);
    }

    @PostMapping("/authenticate")
    public AuthResponseDTO authenticate(@RequestBody AuthRequestDTO authRequestDTO) {
        return authenticationService.authenticate(authRequestDTO);
    }
}