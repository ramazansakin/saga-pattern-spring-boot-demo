package com.appsdeveloperblog.products.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductCreationResponse {
    private UUID id;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public ProductCreationResponse() {
    }

    public ProductCreationResponse(UUID id, String name, BigDecimal price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductCreationResponse(UUID productId, Integer quantity) {
        this.id = productId;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
