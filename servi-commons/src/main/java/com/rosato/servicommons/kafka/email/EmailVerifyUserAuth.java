package com.rosato.servicommons.kafka.email;

import lombok.Data;

@Data
public class EmailVerifyUserAuth {
    private String email;
    private String code;
}
