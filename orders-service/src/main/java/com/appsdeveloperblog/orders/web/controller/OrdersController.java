package com.appsdeveloperblog.orders.web.controller;

import com.appsdeveloperblog.core.dto.Order;
import com.appsdeveloperblog.orders.dto.CreateOrderRequest;
import com.appsdeveloperblog.orders.dto.CreateOrderResponse;
import com.appsdeveloperblog.orders.dto.OrderHistoryResponse;
import com.appsdeveloperblog.orders.service.OrderHistoryService;
import com.appsdeveloperblog.orders.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final OrderService orderService;
    private final OrderHistoryService orderHistoryService;


    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CreateOrderResponse placeOrder(@RequestBody @Valid CreateOrderRequest request) {
        var order = new Order(
                null,
                request.getCustomerId(),
                request.getProductId(),
                request.getProductQuantity(),
                null);

        Order createdOrder = orderService.placeOrder(order);

        var response = new CreateOrderResponse();
        BeanUtils.copyProperties(createdOrder, response);
        return response;
    }

    @GetMapping("/{orderId}/history")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderHistoryResponse> getOrderHistory(@PathVariable UUID orderId) {

        return orderHistoryService.findByOrderId(orderId).stream().map(orderHistory -> {
            OrderHistoryResponse orderHistoryResponse = new OrderHistoryResponse();
            BeanUtils.copyProperties(orderHistory, orderHistoryResponse);
            return orderHistoryResponse;
        }).toList();
    }

}
