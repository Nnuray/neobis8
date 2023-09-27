package com.example.neobis8.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.management.relation.Role;

@Entity
@Table(name = "Users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
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
    private Role role;
}
