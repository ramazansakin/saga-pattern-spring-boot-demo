package com.appsdeveloperblog.core.dto.events;

import java.util.UUID;

public class OrderApprovedEvent {
    private UUID orderId;

    public OrderApprovedEvent() {
    }

    public OrderApprovedEvent(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }
}
