package com.example.neobis8.service;

import com.example.neobis8.dto.product.ProductRequestDTO;
import com.example.neobis8.entity.Product;
import com.example.neobis8.entity.User;
import com.example.neobis8.enums.UserRole;
import com.example.neobis8.exception.ProductNotFoundException;
import com.example.neobis8.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.nio.file.AccessDeniedException;
import java.util.Optional;

import static com.example.neobis8.enums.UserRole.*;

@Service
public class ProductService {
    private ProductService productService;
    private ProductRepository productRepository;

    @Transactional // Если используется база данных, можно использовать аннотацию @Transactional
    public Product addProduct(@RequestBody ProductRequestDTO productRequestDTO, User user) throws AccessDeniedException {
        if (userHasRole(user, SELLER)) {
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

    // Вспомогательный метод для проверки роли пользователя
    private boolean userHasRole(User user, UserRole role) {
        return user.getRoles().contains(role);
    }

    @Transactional
    public void deleteProduct(Long productId, User user) throws ProductNotFoundException, AccessDeniedException {
        Optional<Product> productOptional = productRepository.findById(Math.toIntExact(productId));
        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            // Проверка прав пользователя (например, SELLER)
            if (userHasRole(user, UserRole.SELLER)) {
                productRepository.delete(product); // Удаление продукта
            } else {
                throw new AccessDeniedException("У пользователя нет прав для удаления продукта");
            }
        } else {
            throw new ProductNotFoundException("Продукт с ID " + productId + " не найден");
        }
    }
}
