package com.hwgif.designpattern.strategypattern;


public class StrategyContext {
    private Strategy strategy;

    public StrategyContext() {

    }

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(Integer var1 ,Integer var2){
        return this.strategy.doOperation(var1,var2);
    }
}
