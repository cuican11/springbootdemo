package com.hwgif.designpattern.observerpattern.impl;

import com.hwgif.designpattern.observerpattern.Observer;

/**
 * 观察者1
 */
public class Observer1 implements Observer {
    public void update(){
        System.out.println("observer 1 has received");
    }
}
