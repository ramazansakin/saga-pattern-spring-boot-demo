package com.appsdeveloperblog.products.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductCreationRequest(
        @NotBlank String name,
        @NotNull @Positive BigDecimal price,
        @Positive Integer quantity
) {
}
