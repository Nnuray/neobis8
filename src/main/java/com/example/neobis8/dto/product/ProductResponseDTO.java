package com.example.neobis8.dto.product;

import jakarta.persistence.Lob;

public class ProductResponseDTO {
    private int productId;
    private String name;
    private double price;
    @Lob
    private byte[] photo;
    private String shortDesc;
    private String longDesc;
    private int categoryId;
}
