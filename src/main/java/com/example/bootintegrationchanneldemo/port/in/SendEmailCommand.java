package com.example.bootintegrationchanneldemo.port.in;

import com.example.bootintegrationchanneldemo.domain.EmailParam;
import lombok.Builder;

@Builder
public record SendEmailCommand(String email, String subject, String body) {

    static public SendEmailCommand test() {
        return SendEmailCommand.builder()
                .email("kimbym23@gmail.com")
                .subject("test email")
                .body("test !!")
                .build();
    }

    public EmailParam toParam() {
        return new EmailParam(email, subject, body);
    }
}
