package com.jason.design.visitor;

/**
 * @author 王政
 * @date 2022/9/1 15:50
 */
public class MySubject implements Subject {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getSubject() {
        return "love";
    }

}
