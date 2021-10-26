package com.hwgif.designpattern.observerpattern;

import com.hwgif.designpattern.observerpattern.impl.Observer1;
import com.hwgif.designpattern.observerpattern.impl.Observer2;
import com.hwgif.designpattern.observerpattern.impl.SObserver;

/**
 * Observer Pattern
 * 观察者模式
 * Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
 * 定义对象间一种一对多的依赖关系，使得每当一个对象改变状态，则所有依赖于它的对象都会得到通知并被自动更新。
 */
public class ObserverPatternTestMain {

    public static void main(String[] args) {

        ObserverOperation sob = new SObserver();
        sob.add(new Observer1());
        sob.add(new Observer2());
        sob.operation();
    }
}
