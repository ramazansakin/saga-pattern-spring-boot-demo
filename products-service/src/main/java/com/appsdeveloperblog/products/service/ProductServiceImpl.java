package com.appsdeveloperblog.products.service;

import com.appsdeveloperblog.core.dto.Product;
import com.appsdeveloperblog.core.exceptions.ProductInsufficientQuantityException;
import com.appsdeveloperblog.products.dao.jpa.entity.ProductEntity;
import com.appsdeveloperblog.products.dao.jpa.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product reserve(Product desiredProduct, UUID orderId) {

        ProductEntity productEntity = productRepository.findById(desiredProduct.id()).orElseThrow();
        if (desiredProduct.quantity() > productEntity.getQuantity()) {
            throw new ProductInsufficientQuantityException(productEntity.getId(), orderId);
        }

        productEntity.setQuantity(productEntity.getQuantity() - desiredProduct.quantity());
        productRepository.save(productEntity);

        return new Product(productEntity.getId(), productEntity.getName(),
                productEntity.getPrice(), desiredProduct.quantity());
    }

    @Override
    public void cancelReservation(Product productToCancel, UUID orderId) {

        ProductEntity productEntity = productRepository.findById(productToCancel.id()).orElseThrow();

        productEntity.setQuantity(productEntity.getQuantity() + productToCancel.quantity());
        productRepository.save(productEntity);
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(product.name());
        productEntity.setPrice(product.price());
        productEntity.setQuantity(product.quantity());
        productRepository.save(productEntity);

        return new Product(productEntity.getId(), product.name(), product.price(), product.quantity());
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll().stream()
                .map(entity -> new Product(entity.getId(), entity.getName(), entity.getPrice(), entity.getQuantity()))
                .toList();
    }

}
