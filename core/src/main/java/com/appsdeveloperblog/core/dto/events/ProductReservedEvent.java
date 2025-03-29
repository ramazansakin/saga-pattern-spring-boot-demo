package com.appsdeveloperblog.core.dto.events;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductReservedEvent(
        UUID productId,
        UUID orderId,
        BigDecimal productPrice,
        Integer productQuantity
) {
}
