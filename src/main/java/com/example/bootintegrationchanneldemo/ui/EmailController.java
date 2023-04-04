package com.example.bootintegrationchanneldemo.ui;

import com.example.bootintegrationchanneldemo.application.SendEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final SendEmailService sendEmailService;

    @PostMapping("/test")
    public void sendEmail() {
        sendEmailService.send();
    }
}
