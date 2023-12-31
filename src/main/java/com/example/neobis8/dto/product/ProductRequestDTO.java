package com.example.neobis8.dto.product;

import jakarta.persistence.Lob;

public class ProductRequestDTO {
    private String name;
    private double price;
    @Lob
    private byte[] photo;
    private String shortDesc;
    private String longDesc;
    private int categoryId;

    public String getName() {
        return name;
    }
    public String getShortDesc(){
        return shortDesc;
    }
    public String getLongDesc(){
        return longDesc;
    }

    public double getPrice() {
        return price;
    }

    public byte[] getPhoto() {
        return new byte[0];
    }
}
