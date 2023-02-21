package com.jason.design.iterator;

/**
 * @author 王政
 * @date 2022/8/31 17:23
 */
public interface Collection {

    Iterator iterator();

    Object get(int index);

    int size();

}
