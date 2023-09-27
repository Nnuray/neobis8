package com.example.neobis8.dto.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String email;
    private String login;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String passwordConfirm;

    public String getUsername() {
        return null;
    }

    public String getFirst_name() {
        return null;
    }

    public String getLast_name() {
        return null;
    }
}
