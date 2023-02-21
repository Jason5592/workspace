package com.jason.design.interpreter;

/**
 * @author 王政
 * @date 2022/9/1 17:09
 */
public class Plus implements Expression {

    @Override
    public int interpreter(Context context) {
        return context.getNum1() + context.getNum2();
    }

}
