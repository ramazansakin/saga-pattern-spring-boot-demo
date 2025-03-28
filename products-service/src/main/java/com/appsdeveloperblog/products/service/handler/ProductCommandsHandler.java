package com.appsdeveloperblog.products.service.handler;

import com.appsdeveloperblog.core.dto.Product;
import com.appsdeveloperblog.core.dto.commands.CancelProductReservationCommand;
import com.appsdeveloperblog.core.dto.commands.ProductReservationCancelledEvent;
import com.appsdeveloperblog.core.dto.commands.ReserveProductCommand;
import com.appsdeveloperblog.core.dto.events.ProductReservationFailedEvent;
import com.appsdeveloperblog.core.dto.events.ProductReservedEvent;
import com.appsdeveloperblog.products.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "${products.commands.topic.name}")
@Slf4j
public class ProductCommandsHandler {

    private final ProductService productService;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    private final String productEventsTopicName;


    public ProductCommandsHandler(ProductService productService,
                                  KafkaTemplate<String, Object> kafkaTemplate,
                                  @Value("${products.events.topic.name}") String productEventsTopicName) {
        this.productService = productService;
        this.kafkaTemplate = kafkaTemplate;
        this.productEventsTopicName = productEventsTopicName;
    }

    @KafkaHandler
    public void handleCommand(@Payload ReserveProductCommand command) {

        try {
            Product desiredProduct = new Product(
                    command.productId(), null, null, command.productQuantity());

            Product reservedProduct = productService.reserve(desiredProduct, command.orderId());

            ProductReservedEvent productReservedEvent = new ProductReservedEvent(
                    command.orderId(),
                    command.productId(),
                    reservedProduct.price(),
                    command.productQuantity());

            kafkaTemplate.send(productEventsTopicName, productReservedEvent);

        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);

            ProductReservationFailedEvent productReservationFailedEvent =
                    new ProductReservationFailedEvent(command.productId(),
                            command.orderId(),
                            command.productQuantity());

            kafkaTemplate.send(productEventsTopicName, productReservationFailedEvent);
        }
    }

    @KafkaHandler
    public void handleCommand(@Payload CancelProductReservationCommand command) {
        Product productToCancel = new Product(
                command.productId(), null, null, command.productQuantity());

        productService.cancelReservation(productToCancel, command.orderId());

        ProductReservationCancelledEvent productReservationCancelledEvent =
                new ProductReservationCancelledEvent(command.productId(), command.orderId());

        kafkaTemplate.send(productEventsTopicName, productReservationCancelledEvent);
    }

}
