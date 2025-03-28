package com.artemyakkonen.spring.boot.ttmicroservice1.rabbbitmq;


import com.artemyakkonen.spring.boot.ttmicroservice1.service.IdentifierService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
            rabbitTemplate.convertAndSend("myExchange", "routingKey"
                    , message + " ID:" + identifierService.getServiceId());
            System.out.println("Sent: " + message);
        }
    }

