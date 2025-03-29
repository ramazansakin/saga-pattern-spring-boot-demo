package com.appsdeveloperblog.core.dto.commands;

import java.util.UUID;

public record ReserveProductCommand(
        UUID productId,
        Integer productQuantity,
        UUID orderId
) {
}
