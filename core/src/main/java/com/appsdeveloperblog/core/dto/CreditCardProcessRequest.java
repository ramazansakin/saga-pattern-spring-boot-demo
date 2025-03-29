package com.appsdeveloperblog.core.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.math.BigInteger;

public record CreditCardProcessRequest(
        @NotNull BigInteger cardNumber,
        @NotNull @Positive BigDecimal paymentAmount
) {
}
