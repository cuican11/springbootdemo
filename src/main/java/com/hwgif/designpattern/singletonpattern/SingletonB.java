package com.hwgif.designpattern.singletonpattern;

/**
 * 单例模式 二
 * 2.饿汉式（静态代码块）【可用】
 * 这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。优缺点和 SingletonA 是一样的。
 */
public class SingletonB {
    private static SingletonB instance;
    static {
        instance = new SingletonB();
    }
    private SingletonB(){}
    public static SingletonB getInstance(){
        return instance;
    }
}
