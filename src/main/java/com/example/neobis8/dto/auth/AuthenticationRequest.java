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
public class AuthenticationRequest {
    private String login;
    @JsonIgnore
    private String password;

    public Object getEmail() {
        return null;
    }
}
