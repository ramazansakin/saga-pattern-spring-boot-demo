package com.appsdeveloperblog.products.dao.jpa.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "products")
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
