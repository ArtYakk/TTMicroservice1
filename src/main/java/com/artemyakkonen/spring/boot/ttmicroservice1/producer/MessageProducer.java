package com.artemyakkonen.spring.boot.ttmicroservice1.producer;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
    public class MessageProducer {

        private final RabbitTemplate rabbitTemplate;

        public MessageProducer(RabbitTemplate rabbitTemplate) {
            this.rabbitTemplate = rabbitTemplate;
        }

        public void sendMessage(String message) {
            rabbitTemplate.convertAndSend("myExchange", "routingKey", message);
            System.out.println("Sent: " + message);
        }
    }

