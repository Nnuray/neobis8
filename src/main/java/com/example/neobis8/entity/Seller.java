package com.example.neobis8.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Sellers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sellerId;
    private int productId;
    private String username;
    private String password;
    private String phoneNumber;

}
