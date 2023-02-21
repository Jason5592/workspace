package com.jason.design.templateMethod;


/**
 * @author 王政
 * @date 2022/8/31 16:00
 */
public class Plus extends AbstractCalculator {

    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }

}
