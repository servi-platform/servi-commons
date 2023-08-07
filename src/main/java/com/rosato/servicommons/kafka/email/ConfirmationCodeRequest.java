package com.rosato.servicommons.kafka.email;

import lombok.Data;

@Data
public class ConfirmationCodeRequest {
    private String toEmail;
    private Long userId;
}
