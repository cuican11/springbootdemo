package com.hwgif.designpattern.observerpattern.impl;

import com.hwgif.designpattern.observerpattern.Observer;

/**
 * 观察者1
 */
public class Observer2 implements Observer {
    public void update(){
        System.out.println("observer 2 has received");
    }
}
