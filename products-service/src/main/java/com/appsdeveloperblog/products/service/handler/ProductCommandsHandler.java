package com.appsdeveloperblog.products.service.handler;

import com.appsdeveloperblog.core.dto.commands.ReserveProductCommand;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics="${products.commands.topic.name}")
public class ProductCommandsHandler {

    @KafkaHandler
    public void handleCommand(@Payload ReserveProductCommand command) {

    }
}
