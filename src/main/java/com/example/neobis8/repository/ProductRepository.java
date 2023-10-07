package com.example.neobis8.repository;

import com.example.neobis8.entity.Product;
import com.example.neobis8.entity.User;
import com.example.neobis8.exception.ProductNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.AccessDeniedException;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    void deleteProduct(Long productId, User user) throws AccessDeniedException, ProductNotFoundException;
}
