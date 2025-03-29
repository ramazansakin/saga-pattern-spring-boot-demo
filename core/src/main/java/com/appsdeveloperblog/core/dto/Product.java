package com.appsdeveloperblog.core.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record Product(
        UUID id,
        String name,
        BigDecimal price,
        Integer quantity
) {
}
