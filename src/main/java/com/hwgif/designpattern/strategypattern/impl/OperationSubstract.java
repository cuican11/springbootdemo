package com.hwgif.designpattern.strategypattern.impl;

import com.hwgif.designpattern.strategypattern.Strategy;

public class OperationSubstract implements Strategy {
    public int doOperation(Integer num1,Integer num2){
        return num1 - num2;
    }
}
