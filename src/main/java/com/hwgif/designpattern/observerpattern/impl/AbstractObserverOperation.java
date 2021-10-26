package com.hwgif.designpattern.observerpattern.impl;

import com.hwgif.designpattern.observerpattern.Observer;
import com.hwgif.designpattern.observerpattern.ObserverOperation;

import java.util.Enumeration;
import java.util.Vector;

public abstract class AbstractObserverOperation implements ObserverOperation {

    private Vector<Observer> vector = new Vector<Observer>();

    @Override
    public void add(Observer observer){
        vector.add(observer);
    }
    @Override
    public void del(Observer observer){
        vector.remove(observer);
    }
    @Override
    public void notifyObserver(){
        Enumeration<Observer> enumeration = vector.elements();
        while (enumeration.hasMoreElements()){
            enumeration.nextElement().update();
        }
    }
}
