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
                .userId(user.getUserId()) // Установите значение поля userId на основе User
                .email(user.getEmail()) // Установите значение поля email на основе User
                .username(user.getUsername()) // Установите значение поля username на основе User
                .password(user.getPassword()) // Установите значение поля password на основе User
                .profilePhoto(user.getProfilePhoto()) // Установите значение поля profilePhoto на основе User
                .lastName(user.getLastName()) // Установите значение поля lastName на основе User
                .firstName(user.getFirstName()) // Установите значение поля firstName на основе User
                .phoneNumber(user.getPhoneNumber()) // Установите значение поля phoneNumber на основе User
                .role(user.getRole()) // Установите значение поля role на основе User
                .build();
    }
    public static List<ResponseUserDTO> toResponseUserDTOs(List<User> users){
        return users.stream().map(ResponseUserDTO::toResponseUserDTO).toList();
    }

}