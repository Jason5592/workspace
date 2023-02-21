package com.jason.design.strategy;

/**
 * @author 王政
 * @date 2022/8/31 15:33
 */
public abstract class AbstractCalculator {

    public int[] spit(String exp, String opt) {
        String[] array = exp.split(opt);
        int[] arrayInt = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;
    }

}
