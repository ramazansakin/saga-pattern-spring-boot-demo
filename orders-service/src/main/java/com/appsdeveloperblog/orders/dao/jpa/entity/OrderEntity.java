package com.appsdeveloperblog.orders.dao.jpa.entity;

import com.appsdeveloperblog.core.types.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Table(name = "orders")
@Entity
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "status")
    private OrderStatus status;

    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "product_id")
    private UUID productId;

    @Column(name = "product_quantity")
    private Integer productQuantity;
}
