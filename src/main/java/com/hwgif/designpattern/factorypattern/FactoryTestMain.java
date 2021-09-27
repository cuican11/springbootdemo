package com.hwgif.designpattern.factorypattern;

public class FactoryTestMain {

    /**
     * 工厂模式
     *
     * 现在需要创建几个对象，且这几个对象有共同特征，则不需要具体创建各个对象，而是创建对象工厂类即可。
     *
     * @param args
     */

    public static void main(String[] args) {
        Sender sender = SendFactory.productMailSender();
        sender.send();
        sender = SendFactory.productSMSSender();
        sender.send();
    }
}
