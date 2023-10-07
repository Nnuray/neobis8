package com.example.neobis8.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String name;
    private double price;
    @Lob
    private byte[] photo;
    private String shortDesc;
    private String longDesc;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
}
