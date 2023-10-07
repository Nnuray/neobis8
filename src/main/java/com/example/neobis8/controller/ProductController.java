package com.example.neobis8.controller;

import com.example.neobis8.dto.product.ProductRequestDTO;
import com.example.neobis8.entity.Product;
import com.example.neobis8.entity.User;
import com.example.neobis8.enums.UserRole;
import com.example.neobis8.exception.ProductNotFoundException;
import com.example.neobis8.repository.ProductRepository;
import com.example.neobis8.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;
    private ProductRepository productRepository;

    @PostMapping("/AddProduct")
    @PreAuthorize("hasRole('SELLER')")
    @SecurityRequirement(name = "JWT")
    public Product addProduct(@RequestBody ProductRequestDTO productRequestDTO, @AuthenticationPrincipal User user) throws AccessDeniedException {
        if (userHasRole(user, UserRole.SELLER)) {
            Product product = new Product();
            product.setName(productRequestDTO.getName());
            product.setShortDesc(productRequestDTO.getShortDesc());
            product.setLongDesc(productRequestDTO.getLongDesc());
            product.setPrice(productRequestDTO.getPrice());
            product.setPhoto(productRequestDTO.getPhoto());

            return productRepository.save(product);
        } else {
            throw new AccessDeniedException("У пользователя нет прав для добавления продукта");
        }
    }

    private boolean userHasRole(User user, UserRole role) {
        return user.getRoles().contains(role);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    @PreAuthorize("hasRole('SELLER')")
    @SecurityRequirement(name = "JWT")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId, @AuthenticationPrincipal User user) throws AccessDeniedException, ProductNotFoundException {
            productService.deleteProduct(productId, user);
            return ResponseEntity.ok("Продукт успешно удален");
        }
    }
