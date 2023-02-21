package com.jason.design.visitor;

/**
 * @author 王政
 * @date 2022/9/1 15:54
 */
public class Test {

    public static void main(String[] args) {
        Visitor visitor = new MyVisitor();
        Subject subject = new MySubject();
        subject.accept(visitor);
    }

}
