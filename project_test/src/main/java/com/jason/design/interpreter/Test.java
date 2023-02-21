package com.jason.design.interpreter;

/**
 * @author 王政
 * @date 2022/9/1 17:10
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(new Minus().interpreter(new Context(new Plus().interpreter(new Context(1, 2)), 8)));
    }

}
