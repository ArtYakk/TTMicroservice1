package com.artemyakkonen.spring.boot.ttmicroservice1.rabbbitmq;

import com.artemyakkonen.spring.boot.ttmicroservice1.service.IdentifierService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableScheduling
public class ScheduledMessageProducer {

    private final RabbitTemplate rabbitTemplate;
    private final IdentifierService identifierService;

    @Autowired
    public ScheduledMessageProducer(RabbitTemplate rabbitTemplate, IdentifierService identifierService) {
        this.rabbitTemplate = rabbitTemplate;
        this.identifierService = identifierService;
    }

    @Scheduled(fixedRate = 5000) // Отправлять каждые 1000 мс (1 сек)
    public void sendScheduledMessage() {
        String message = "Active " + LocalDateTime.now();
        rabbitTemplate.convertAndSend("myExchange", "routingKey"
                , message + " ID:" + identifierService.getServiceId());
        System.out.println("Sent: " + message);
    }
}

