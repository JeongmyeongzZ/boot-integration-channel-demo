package com.example.bootintegrationchanneldemo.adapter.in;

import com.example.bootintegrationchanneldemo.port.in.SendEmailCommand;
import com.example.bootintegrationchanneldemo.port.in.SendEmailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final SendEmailUseCase sendEmailService;

    @PostMapping("/test")
    public void sendEmail() {
        sendEmailService.send(SendEmailCommand.test());
    }
}
