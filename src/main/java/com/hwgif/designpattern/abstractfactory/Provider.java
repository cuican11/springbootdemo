package com.hwgif.designpattern.abstractfactory;

import com.hwgif.designpattern.factorypattern.Sender;

public interface Provider {
    public Sender produce();
}
