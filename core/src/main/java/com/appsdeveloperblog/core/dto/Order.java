package com.appsdeveloperblog.core.dto;


import com.appsdeveloperblog.core.types.OrderStatus;

import java.util.UUID;

public class Order {
    private UUID orderId;
    private UUID customerId;
    private UUID productId;
    private Integer productQuantity;
    private OrderStatus status;

    public Order() {
    }

    public Order(UUID orderId, UUID customerId, UUID productId, Integer productQuantity, OrderStatus status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productId = productId;
        this.productQuantity = productQuantity;
        this.status = status;
    }

    public Order(UUID customerId, UUID productId, Integer productQuantity, OrderStatus status) {
        this.customerId = customerId;
        this.productId = productId;
        this.productQuantity = productQuantity;
        this.status = status;
    }

    public UUID getProductId() {
        return productId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }
}
