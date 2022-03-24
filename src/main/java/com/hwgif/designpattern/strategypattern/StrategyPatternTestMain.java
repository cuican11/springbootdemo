package com.hwgif.designpattern.strategypattern;

import com.hwgif.designpattern.strategypattern.impl.OperationAdd;
import com.hwgif.designpattern.strategypattern.impl.OperationMultiply;
import com.hwgif.designpattern.strategypattern.impl.OperationSubstract;

public class StrategyPatternTestMain {

    /**
     * 设计模式   策略模式
     *策略模式及与工厂模式的区别
     * 定义与使用场合：一个系统需要动态地在几种类似的算法中选择一种。
     * 与工厂模式异同：实例化一个对象的位置不同。对工厂模式而言，实例化对象是放在了工厂类里面。而策略模式实例化对象的操作在调用的地方。本质都是继承与多态。
     * 例子： 现有 加/减/乘 几种算法，输入参数返回值都一样（可以理解成类似的算法）。现在需要在调用时动态配置算法策略，实现对不同算法的调用。
     * @param args
     */
    public static void main(String[] args) {


//        context = new StrategyContext(new OperationSubstract());
//        Integer sub =  context.executeStrategy(1,2);
//        System.out.println(sub);
//        context = new StrategyContext(new OperationMultiply());
//        Integer mul =  context.executeStrategy(19,2);
//        System.out.println(mul);

    }
}
