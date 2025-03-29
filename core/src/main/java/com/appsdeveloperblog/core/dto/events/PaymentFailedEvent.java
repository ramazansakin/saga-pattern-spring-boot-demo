package com.appsdeveloperblog.core.dto.events;

import java.util.UUID;

public record PaymentFailedEvent(
        UUID orderId,
        UUID productId,
        Integer productQuantity) {
}
