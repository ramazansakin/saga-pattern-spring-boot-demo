package com.appsdeveloperblog.core.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class Payment {
    private UUID id;
    private UUID orderId;
    private UUID productId;
    private BigDecimal productPrice;
    private Integer productQuantity;

    public Payment() {
    }

    public Payment(UUID id, UUID orderId, UUID productId, BigDecimal productPrice, Integer productQuantity) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }


    public Payment(UUID orderId, UUID productId, BigDecimal productPrice, Integer productQuantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
}

