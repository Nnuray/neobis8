package com.example.neobis8.service;

import com.example.neobis8.dto.auth.AuthRequestDTO;
import com.example.neobis8.dto.auth.AuthResponseDTO;
import com.example.neobis8.dto.user.RequestUserDTO;
import com.example.neobis8.entity.User;
import com.example.neobis8.jwt.JwtService;
import com.example.neobis8.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthService implements AuthenticationService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    JwtService jwtService;
    @Override
    public AuthResponseDTO register(RequestUserDTO requestUserDTO) {
        User newUser = new User();
        newUser.setEmail(requestUserDTO.getEmail());
        newUser.setPassword(passwordEncoder.encode(requestUserDTO.getPassword()));
        userRepository.save(newUser);

        String token = jwtService.generateToken(newUser);

        return new AuthResponseDTO(token);
    }

    @Override
    public AuthResponseDTO authenticate(AuthRequestDTO authRequestDTO) {
        User user = userRepository.findByUsername(authRequestDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));

        if (!passwordEncoder.matches(authRequestDTO.getPassword(), user.getPassword())) {
            throw new UsernameNotFoundException("Неверные учетные данные");
        }
        String token = jwtService.generateToken(user);

        return new AuthResponseDTO(token);
    }
}





