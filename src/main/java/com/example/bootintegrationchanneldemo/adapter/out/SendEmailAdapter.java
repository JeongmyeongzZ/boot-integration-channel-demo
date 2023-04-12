package com.example.bootintegrationchanneldemo.adapter.out;

import com.example.bootintegrationchanneldemo.domain.EmailParam;
import com.example.bootintegrationchanneldemo.port.out.SendEmailPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SendEmailAdapter implements SendEmailPort {
    private final JavaMailSender javaMailSender;

    @Override
    public void send(EmailParam param) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(param.email());
        message.setSubject(param.subject());
        message.setText(param.body());

        javaMailSender.send(message);
    }
}
