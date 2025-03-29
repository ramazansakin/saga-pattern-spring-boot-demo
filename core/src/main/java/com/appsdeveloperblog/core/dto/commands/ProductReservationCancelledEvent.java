package com.appsdeveloperblog.core.dto.commands;

import java.util.UUID;

public record ProductReservationCancelledEvent(
        UUID productId,
        UUID orderId
) {
}
