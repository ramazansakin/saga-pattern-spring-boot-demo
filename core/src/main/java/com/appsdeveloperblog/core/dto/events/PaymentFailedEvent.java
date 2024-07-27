package com.appsdeveloperblog.core.dto.events;

import java.util.UUID;

public class PaymentFailedEvent {
    private UUID orderId;
    private UUID productId;
    private Integer productQuantity;

    public PaymentFailedEvent() {
    }

    public PaymentFailedEvent(UUID orderId, UUID productId, Integer productQuantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.productQuantity = productQuantity;
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

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
}
