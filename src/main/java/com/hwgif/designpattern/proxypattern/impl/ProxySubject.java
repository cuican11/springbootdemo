package com.hwgif.designpattern.proxypattern.impl;

import com.hwgif.designpattern.proxypattern.Subject;

public class ProxySubject implements Subject {
    private Subject subject ;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    public void request(){
        System.out.println("proxy subject request begin");
        subject.request();
        System.out.println("proxy subject request end");
    }
}
