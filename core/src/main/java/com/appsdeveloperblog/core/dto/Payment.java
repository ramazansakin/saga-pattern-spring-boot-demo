package com.appsdeveloperblog.core.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record Payment(
        UUID id,
        UUID orderId,
        UUID productId,
        BigDecimal productPrice,
        Integer productQuantity
) {
}

