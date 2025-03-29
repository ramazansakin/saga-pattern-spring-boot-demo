package com.appsdeveloperblog.core.dto.events;

import java.util.UUID;

public record OrderCreatedEvent(
        UUID orderId,
        UUID customerId,
        UUID productId,
        Integer productQuantity
) {
}
