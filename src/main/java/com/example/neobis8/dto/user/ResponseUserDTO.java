package com.example.neobis8.dto.user;

import com.example.neobis8.entity.User;
import com.example.neobis8.enums.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseUserDTO {
    int userId;
    private String email;
    private String username;
    private String password;
    @Lob
    private byte[] profilePhoto;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private java.util.Date dateOfBirth;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public static ResponseUserDTO toResponseUserDTO(User user) {
        return ResponseUserDTO.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .username(user.getUsername())
                .password(user.getPassword())
                .profilePhoto(user.getProfilePhoto())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole())
                .build();
    }
    public static List<ResponseUserDTO> toResponseUserDTOs(List<User> users){
        return users.stream().map(ResponseUserDTO::toResponseUserDTO).toList();
    }

}