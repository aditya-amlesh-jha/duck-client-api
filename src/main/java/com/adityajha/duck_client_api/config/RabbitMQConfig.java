package com.adityajha.duck_client_api.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class RabbitMQConfig {
    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.queue1.name}")
    private String queueNameOne;

    @Value("${rabbitmq.queue2.name}")
    private String queueNameTwo;

    @Value("${rabbitmq.routing1.key}")
    private String routingKeyOne;

    @Value("${rabbitmq.routing2.key}")
    private String routingKeyTwo;

    @Bean
    public Queue queueOne(){
        return new Queue(queueNameOne, true);
    }

//    can also use qualifier or primary to resolve bean of same type, default is by methodName
    @Bean
    public Queue queueTwo(){
        return new Queue(queueNameTwo, true);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchangeName, true, false);
    }

    @Bean
    public Binding bindingOne(Queue queueOne, TopicExchange exchange){
        return BindingBuilder.bind(queueOne)
                .to(exchange)
                .with(routingKeyOne);
    }

    @Bean
    public Binding bindingTwo(Queue queueTwo, TopicExchange exchange){
        return BindingBuilder.bind(queueTwo)
                .to(exchange)
                .with(routingKeyTwo);
    }
}
