package com.artemyakkonen.spring.boot.ttmicroservice1.rabbbitmq;


import com.artemyakkonen.spring.boot.ttmicroservice1.service.IdentifierService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Date;

@Component
    public class MessageProducer {

        private final RabbitTemplate rabbitTemplate;
        private final IdentifierService identifierService;

        @Autowired
        public MessageProducer(RabbitTemplate rabbitTemplate, IdentifierService identifierService) {
            this.rabbitTemplate = rabbitTemplate;
            this.identifierService = identifierService;
        }

        public void sendMessage(String message) {
            String fullMessage = message + " ID:" + identifierService.getServiceId();
            rabbitTemplate.convertAndSend("myExchange", "routingKey", fullMessage);
            System.out.println("Sent: " + message);
        }
    }

