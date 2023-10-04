package com.example.neobis8.service;

import com.example.neobis8.dto.auth.AuthRequestDTO;
import com.example.neobis8.dto.auth.AuthResponseDTO;
import com.example.neobis8.dto.user.RequestUserDTO;


public interface AuthenticationService {
    AuthResponseDTO register(RequestUserDTO userDTO);

    AuthResponseDTO authenticate(AuthRequestDTO authRequestDTO);

    AuthResponseDTO login(AuthRequestDTO authRequestDTO);
}