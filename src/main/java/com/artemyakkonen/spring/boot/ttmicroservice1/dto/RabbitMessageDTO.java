package com.artemyakkonen.spring.boot.ttmicroservice1.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RabbitMessageDTO implements Serializable {
    private String uuid;
    private LocalDateTime timestamp;
    private String body;
}
