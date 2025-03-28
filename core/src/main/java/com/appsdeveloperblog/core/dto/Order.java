package com.appsdeveloperblog.core.dto;


import com.appsdeveloperblog.core.types.OrderStatus;

import java.util.UUID;

public record Order(
        UUID orderId,
        UUID customerId,
        UUID productId,
        Integer productQuantity,
        OrderStatus status) {
}
