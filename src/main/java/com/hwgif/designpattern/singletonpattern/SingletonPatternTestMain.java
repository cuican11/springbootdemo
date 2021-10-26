package com.hwgif.designpattern.singletonpattern;

/**
 *Singleton Pattern
 * 单例模式
 * Ensure a class has only one instance, and provide a global point of access to it.
 * 确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例。
 * 定义及使用场合：只有一个对象被创建。
 * 例子：
 * 建议采用 饿汉式 创建方法。线程安全，容易实现。初始化慢一点。
 */
public class SingletonPatternTestMain {

    public static void main(String[] args) {
        SingletonC sc = SingletonC.getInstance();

    }
}
