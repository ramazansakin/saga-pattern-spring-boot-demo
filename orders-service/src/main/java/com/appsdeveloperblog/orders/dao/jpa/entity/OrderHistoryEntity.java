package com.appsdeveloperblog.orders.dao.jpa.entity;

import com.appsdeveloperblog.core.types.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Table(name = "orders_history")
@Entity
@Data
public class OrderHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "order_id")
    private UUID orderId;

    @Column(name = "status")
    private OrderStatus status;

    @Column(name = "created_at")
    private Timestamp createdAt;

}
