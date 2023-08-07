package com.rosato.servicommons.kafka.email;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmailLoginNotificationRequest {
    private String email;
    private String username;
    private LocalDateTime loginTime;
}
