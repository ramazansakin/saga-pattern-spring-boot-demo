package com.appsdeveloperblog.products.web.controller;

import com.appsdeveloperblog.core.dto.Product;
import com.appsdeveloperblog.products.dto.ProductCreationRequest;
import com.appsdeveloperblog.products.dto.ProductCreationResponse;
import com.appsdeveloperblog.products.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAll() {
        return productService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductCreationResponse save(@RequestBody @Valid ProductCreationRequest request) {

        var product = new Product(null, request.name(), request.price(), request.quantity());
        Product result = productService.save(product);

        return new ProductCreationResponse(result.id(), result.name(), result.price(), result.quantity());
    }
}
