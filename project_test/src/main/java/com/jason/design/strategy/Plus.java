package com.jason.design.strategy;

/**
 * @author 王政
 * @date 2022/8/31 15:36
 */
public class Plus extends AbstractCalculator implements ICalculator {

    @Override
    public int calculate(String exp) {
        int[] arrayInt = spit(exp, "\\+");
        return arrayInt[0] + arrayInt[1];
    }

}
