package com.example.bootintegrationchanneldemo.port.out;

import com.example.bootintegrationchanneldemo.domain.EmailParam;

public interface SendEmailPort {
    void send(EmailParam param);
}
