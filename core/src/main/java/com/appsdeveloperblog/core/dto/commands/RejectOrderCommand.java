package com.appsdeveloperblog.core.dto.commands;

import java.util.UUID;

public record RejectOrderCommand(
        UUID orderId
) {
}
