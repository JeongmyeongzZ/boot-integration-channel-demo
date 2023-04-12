package com.example.bootintegrationchanneldemo.adapter.in;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ImapChannelAdapter {
    @ServiceActivator(inputChannel = "emailInChannel")
    public void handleMessage(MimeMessage message) throws MessagingException, IOException {
        System.out.println("### Message Received!!!");
        System.out.println("### " + message.getSubject());
        System.out.println("### " + message.getFrom()[0]);
        System.out.println("### " + message.getContent().toString());
    }
}
