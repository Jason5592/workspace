package com.jason.design.iterator;

/**
 * @author 王政
 * @date 2022/8/31 17:23
 */
public interface Iterator {

    /**
     * 前移
     *
     * @return
     */
    Object previous();

    /**
     * 后移
     *
     * @return
     */
    Object next();

    boolean hasNext();

    Object first();

}
