package com.example.bootintegrationchanneldemo.port.in;

import com.example.bootintegrationchanneldemo.port.out.SendEmailPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SendEmailUseCase {

    private final SendEmailPort sendEmailPort;

    public void send(SendEmailCommand command) {
        sendEmailPort.send(command.toParam());
    }
}
