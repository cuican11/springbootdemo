package com.hwgif.designpattern.abstractfactory;

import com.hwgif.designpattern.abstractfactory.impl.SendMailFactory;
import com.hwgif.designpattern.abstractfactory.impl.SendSMSFactory;
import com.hwgif.designpattern.factorypattern.Sender;

public class AbstractfactoryTestMain {

    /**
     * 设计模式  抽象工厂模式
     * @param args
     */

    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.send();

        provider = new SendSMSFactory();
        sender = provider.produce();
        sender.send();
    }
}
