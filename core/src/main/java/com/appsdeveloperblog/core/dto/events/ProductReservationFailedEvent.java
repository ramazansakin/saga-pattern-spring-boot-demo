package com.appsdeveloperblog.core.dto.events;

import java.util.UUID;

public record ProductReservationFailedEvent(
        UUID productId,
        UUID orderId,
        Integer productQuantity
) {
}
