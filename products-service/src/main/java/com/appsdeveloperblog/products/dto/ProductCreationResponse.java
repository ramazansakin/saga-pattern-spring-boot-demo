package com.appsdeveloperblog.products.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductCreationResponse(
        UUID productId,
        String name,
        BigDecimal price,
        Integer quantity
) {
}
