package com.example.bootintegrationchanneldemo.infrastructure;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mail.ImapIdleChannelAdapter;
import org.springframework.integration.mail.ImapMailReceiver;
import org.springframework.messaging.MessageChannel;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class EmailIntegrationConfiguration {
    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Bean
    public MessageChannel emailInChannel() {
        return new DirectChannel();
    }

    @Bean
    public ImapIdleChannelAdapter imapIdleChannelAdapter(MessageChannel emailInChannel) {
        ImapMailReceiver imapMailReceiver = new ImapMailReceiver(createImapUrl());
        imapMailReceiver.setJavaMailProperties(mailProperties());
        imapMailReceiver.setShouldMarkMessagesAsRead(false);
        imapMailReceiver.setShouldDeleteMessages(false);
        imapMailReceiver.afterPropertiesSet();
        ImapIdleChannelAdapter imapIdleChannelAdapter = new ImapIdleChannelAdapter(imapMailReceiver);
        imapIdleChannelAdapter.setAutoStartup(true);
        imapIdleChannelAdapter.setOutputChannel(emailInChannel);
        imapIdleChannelAdapter.afterPropertiesSet();
        return imapIdleChannelAdapter;
    }

    public Properties mailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.imap.socketFactory.fallback", "false");
        properties.setProperty("mail.store.protocol", "imaps");
        properties.setProperty("mail.debug", "true");
        properties.setProperty("mail.imap.ssl", "true");
        return properties;
    }

    @ServiceActivator(inputChannel = "emailInChannel")
    public void handleMessage(MimeMessage message) throws MessagingException, IOException {
        System.out.println("### Message Received!!!");
        System.out.println("### " + message.getSubject());
        System.out.println("### " + message.getFrom()[0]);
        System.out.println("### " + message.getContent().toString());
    }

    private String createImapUrl() {
        return String.format("imaps://%s:%s@imap.gmail.com:993/inbox", username, password);
    }
}
