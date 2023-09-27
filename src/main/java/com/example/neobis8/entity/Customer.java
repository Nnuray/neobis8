package com.example.neobis8.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String email;
    private String username;
    private String password;
    @Lob
    private byte[] profilePhoto;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private java.util.Date dateOfBirth;
}
