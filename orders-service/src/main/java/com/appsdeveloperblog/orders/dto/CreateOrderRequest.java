package com.appsdeveloperblog.orders.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public class CreateOrderRequest {
    @NotNull
    private UUID customerId;
    @NotNull
    private UUID productId;
    @NotNull
    @Positive
    private Integer productQuantity;

    public CreateOrderRequest() {
    }

    public CreateOrderRequest(UUID customerId, UUID productId, Integer productQuantity) {
        this.customerId = customerId;
        this.productId = productId;
        this.productQuantity = productQuantity;
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
}
