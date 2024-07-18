package com.appsdeveloperblog.core.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CreditCardProcessRequest {
    @NotNull
    @Positive
    private BigInteger creditCardNumber;
    @NotNull
    @Positive
    private BigDecimal paymentAmount;

    public CreditCardProcessRequest() {
    }

    public CreditCardProcessRequest(BigInteger creditCardNumber, BigDecimal paymentAmount) {
        this.creditCardNumber = creditCardNumber;
        this.paymentAmount = paymentAmount;
    }

    public BigInteger getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(BigInteger creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
