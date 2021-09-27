package com.hwgif.designpattern.abstractfactory.impl;

import com.hwgif.designpattern.abstractfactory.Provider;
import com.hwgif.designpattern.factorypattern.Sender;
import com.hwgif.designpattern.factorypattern.impl.SMSSender;
import org.springframework.stereotype.Service;

@Service
public class SendSMSFactory implements Provider {
    @Override
    public Sender produce(){
        return new SMSSender();
    }
}
