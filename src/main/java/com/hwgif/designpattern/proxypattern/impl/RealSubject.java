package com.hwgif.designpattern.proxypattern.impl;

import com.hwgif.designpattern.proxypattern.Subject;

public class RealSubject implements Subject {
    public void request(){
        System.out.println("this is realSubject");
    }
}
