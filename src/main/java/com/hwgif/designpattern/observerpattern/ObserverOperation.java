package com.hwgif.designpattern.observerpattern;

/**
 *
 */
public interface ObserverOperation {
    public void add(Observer observer);
    public void del(Observer observer);
    public void notifyObserver();
    public void operation();
}
