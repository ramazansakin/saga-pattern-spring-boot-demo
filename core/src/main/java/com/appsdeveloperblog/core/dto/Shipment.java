package com.appsdeveloperblog.core.dto;

import java.util.UUID;

public class Shipment {
    private UUID id;
    private UUID orderId;
    private UUID paymentId;

    public Shipment() {
    }

    public Shipment(UUID id, UUID orderId, UUID paymentId) {
        this.id = id;
        this.orderId = orderId;
        this.paymentId = paymentId;
    }

    public Shipment(UUID orderId, UUID paymentId) {
        this.orderId = orderId;
        this.paymentId = paymentId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }
}
