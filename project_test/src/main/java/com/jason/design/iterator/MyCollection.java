package com.jason.design.iterator;

/**
 * @author 王政
 * @date 2022/8/31 17:39
 */
public class MyCollection implements Collection {

    public String[] collection = {"A","B","C","D","E"};

    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    @Override
    public Object get(int index) {
        return collection[index];
    }

    @Override
    public int size() {
        return collection.length;
    }

}
