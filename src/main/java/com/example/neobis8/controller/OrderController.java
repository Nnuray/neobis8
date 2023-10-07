package com.example.neobis8.controller;

import com.example.neobis8.dto.order.OrderRequestDTO;
import com.example.neobis8.entity.Order;
import com.example.neobis8.entity.User;
import com.example.neobis8.service.OrderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private OrderService orderService;

    @PostMapping("/crateOrder")
    @SecurityRequirement(name = "JWT")
    public Order createOrder(@RequestBody OrderRequestDTO requestOrderDTO,
                             @AuthenticationPrincipal User user){
        return orderService.createOrder(requestOrderDTO, user);
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    @SecurityRequirement(name = "JWT")
    public ResponseEntity<String> deleteOrder(@PathVariable("orderId") Long id,
                                              @AuthenticationPrincipal User user){
        return orderService.deleteOrder(Math.toIntExact(id), user);
    }

}

