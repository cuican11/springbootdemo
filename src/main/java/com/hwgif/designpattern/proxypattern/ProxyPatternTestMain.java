package com.hwgif.designpattern.proxypattern;

import com.hwgif.designpattern.proxypattern.impl.ProxySubject;
import com.hwgif.designpattern.proxypattern.impl.RealSubject;

/**
 * 设计模式  代理模式
 * Proxy pattern（
 * Provide a surrogate (代理) or placeholder for another object to control access to it.
 * 为其他对象提供一种代理以控制对这个对象的访问。
 *
 * 1、RealSubject 是委托类，Proxy 是代理类；
 * 2、Subject 是委托类和代理类的接口；
 * 3、request() 是委托类和代理类的共同方法；
 *
 */
public class ProxyPatternTestMain {
    public static void main(String[] args) {

        RealSubject realSubject = new RealSubject();
        ProxySubject proxy = new ProxySubject(realSubject);
        proxy.request();
    }
}
