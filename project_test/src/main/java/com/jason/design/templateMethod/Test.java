package com.jason.design.templateMethod;

/**
 * @author 王政
 * @date 2022/8/31 16:00
 */
public class Test {

    public static void main(String[] args) {
        AbstractCalculator plus = new Plus();
        System.out.println(plus.calculate("9+9", "\\+"));
        System.out.println(plus.calculate(1, 2));
    }

}
