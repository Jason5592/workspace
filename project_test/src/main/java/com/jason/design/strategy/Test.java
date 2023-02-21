package com.jason.design.strategy;

/**
 * @author 王政
 * @date 2022/8/31 15:39
 */
public class Test {

    public static void main(String[] args) {
        ICalculator plus = new Plus();
        System.out.println(plus.calculate("3+5"));
    }

}
