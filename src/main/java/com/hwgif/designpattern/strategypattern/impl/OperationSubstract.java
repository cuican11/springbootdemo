package com.hwgif.designpattern.strategypattern.impl;

import com.hwgif.designpattern.strategypattern.Strategy;
import com.hwgif.designpattern.strategypattern.StrategyName;
import org.springframework.stereotype.Component;

@Component

@StrategyName("substract")
public class OperationSubstract implements Strategy {
    public int doOperation(Integer num1,Integer num2){
        return num1 - num2;
    }
}
