package com.example.neobis8.dto.auth;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthRequestDTO {
    String email;

    String password;

    public String getUsername() {
        return email;
    }
}