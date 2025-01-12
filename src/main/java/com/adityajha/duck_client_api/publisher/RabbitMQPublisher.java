package com.adityajha.duck_client_api.publisher;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQPublisher {
    @Value("{rabbitmq.exchange.name}")
    private String exchangeName;
    @Value("{rabbitmq.routing1.key}")
    private String routingKeyOne;
    @Value("{rabbitmq.routing2.key}")
    private String routingKeyTwo;
    private final RabbitTemplate rabbitTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQPublisher.class);

    public void sendMessageToQueueOne(String message){
        LOGGER.info("Message sent to queue one with routing {} -> {}", routingKeyOne, message);
        rabbitTemplate.convertAndSend(exchangeName, routingKeyOne, message);
    }

    public void sendMessageToQueueTwo(String message){
        LOGGER.info("Message sent to queue one with routing {} -> {}", routingKeyTwo, message);
        rabbitTemplate.convertAndSend(exchangeName, routingKeyTwo, message);
    }
}
