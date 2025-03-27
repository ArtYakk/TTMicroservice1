package com.artemyakkonen.spring.boot.ttmicroservice1.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue myQueue() {
        return new Queue("myQueue", true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("myExchange");
    }

    @Bean
    public Binding binding(Queue myQueue, DirectExchange exchange) {
        return BindingBuilder.bind(myQueue).to(exchange).with("routingKey");
    }
}

