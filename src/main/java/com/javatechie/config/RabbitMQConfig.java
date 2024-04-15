package com.javatechie.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "direct-exchange";
    public static final String ROUTING_KEY = "customerSearchRequest";
    public static final String QUEUE_NAME = "CUSTOMER_REQUEST";

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue exampleQueue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public Binding binding(Queue exampleQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(exampleQueue).to(directExchange).with(ROUTING_KEY);
    }
}

