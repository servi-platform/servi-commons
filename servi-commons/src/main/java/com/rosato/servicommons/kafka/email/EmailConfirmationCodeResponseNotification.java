package com.rosato.servicommons.kafka.email;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmailConfirmationCodeResponseNotification {
    private String toEmail;
    private LocalDateTime sentAt;
    private boolean consumed;
}
