package com.hwgif.designpattern.observerpattern.impl;

public class SObserver extends AbstractObserverOperation{
    @Override
    public void operation(){
        System.out.println("update self");
        notifyObserver();
    }
}
