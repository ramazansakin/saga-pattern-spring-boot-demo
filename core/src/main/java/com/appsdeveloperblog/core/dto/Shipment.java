package com.appsdeveloperblog.core.dto;

import java.util.UUID;

public record Shipment(
        UUID id,
        UUID orderId,
        UUID paymentId
) {
}
