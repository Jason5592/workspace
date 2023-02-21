package com.jason.design.visitor;

/**
 * @author 王政
 * @date 2022/9/1 15:49
 */
public class MyVisitor implements Visitor {

    @Override
    public void visit(Subject subject) {
        System.out.println("visit the subject：" + subject.getSubject());
    }

}
