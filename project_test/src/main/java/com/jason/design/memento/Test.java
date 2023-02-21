package com.jason.design.memento;

/**
 * @author 王政
 * @date 2022/8/31 18:30
 */
public class Test {

    public static void main(String[] args) {
        Original original = new Original("egg");
        System.out.println(original.getValue());

        Storage storage = new Storage(original.createMemento());

        original.setValue("apple");
        System.out.println(original.getValue());

        original.restoreMemento(storage.getMemento());
        System.out.println(original.getValue());
    }

}
