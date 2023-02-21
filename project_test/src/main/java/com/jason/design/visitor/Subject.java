package com.jason.design.visitor;

/**
 * @author 王政
 * @date 2022/9/1 15:48
 */
public interface Subject {

    void accept(Visitor visitor);

    String getSubject();

}
