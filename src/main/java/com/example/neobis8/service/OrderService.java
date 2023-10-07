package com.example.neobis8.service;

import com.example.neobis8.dto.order.OrderRequestDTO;
import com.example.neobis8.entity.Order;
import com.example.neobis8.entity.Product;
import com.example.neobis8.entity.User;
import com.example.neobis8.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private ProductService productService;

    public Order createOrder(OrderRequestDTO orderRequestDTO, User user) {
        Order order = new Order();
        order.setUserId(user.getId());
        order.setOrderDate(LocalDateTime.now());
        Order savedOrder = orderRepository.save(order);
        return savedOrder;
    }

    public ResponseEntity<String> deleteOrder(Integer id, User user) {
        orderRepository.deleteById(id);
        return ResponseEntity.ok("Order with ID " + id + " has been deleted");
    }
}
