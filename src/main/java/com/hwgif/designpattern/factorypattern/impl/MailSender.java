package com.hwgif.designpattern.factorypattern.impl;

import com.hwgif.designpattern.factorypattern.Sender;
import org.springframework.stereotype.Service;

@Service
public class MailSender implements Sender {
    @Override
    public void send(){
        System.out.println("发送email");
    }
}
