package com.appsdeveloperblog.core.dto.commands;

import java.util.UUID;

public class ApproveOrderCommand {
    private UUID orderId;

    public ApproveOrderCommand() {
    }

    public ApproveOrderCommand(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }
}
