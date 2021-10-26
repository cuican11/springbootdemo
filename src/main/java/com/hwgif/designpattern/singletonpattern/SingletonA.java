package com.hwgif.designpattern.singletonpattern;

/**
 * 单例模式  一
 * 1.饿汉式（静态常量）【可用】
 * 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 */
public class SingletonA {

    private String str = "default string";

    // 创建一个对象
    private static SingletonA INSTANCE = new SingletonA();
    // 让构造函数private 使之不能被实例化

    private SingletonA() {
    }
    // 提供get方法
    public static SingletonA getInstance(){
        return INSTANCE;
    }
}
