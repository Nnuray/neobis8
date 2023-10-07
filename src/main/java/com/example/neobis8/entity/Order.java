package com.example.neobis8.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private int userId;
    private int productId;
    private java.util.Date date;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

}
