package com.appsdeveloperblog.core.dto.commands;

import java.util.UUID;

public record CancelProductReservationCommand(
        UUID productId,
        UUID orderId,
        Integer productQuantity
) {
}
