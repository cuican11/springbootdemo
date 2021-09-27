
package com.hwgif.designpattern.factorypattern;

import com.hwgif.designpattern.factorypattern.impl.MailSender;
import com.hwgif.designpattern.factorypattern.impl.SMSSender;

/**
 * 设计模式 工厂模式
 * 工厂
 */
public class SendFactory {
    public static MailSender productMailSender(){
        return new MailSender();
    }
    public static SMSSender productSMSSender(){
        return new SMSSender();
    }
}
