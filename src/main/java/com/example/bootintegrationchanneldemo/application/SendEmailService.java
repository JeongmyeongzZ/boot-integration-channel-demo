package com.example.bootintegrationchanneldemo.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SendEmailService {

    private final JavaMailSender javaMailSender;

    public void send() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("kimbym23@gmail.com");
        message.setSubject("Test Email Title");
        message.setText("Some Test Body");

        javaMailSender.send(message);
    }
}
