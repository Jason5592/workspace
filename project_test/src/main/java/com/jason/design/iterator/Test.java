package com.jason.design.iterator;

/**
 * @author 王政
 * @date 2022/8/31 17:46
 */
public class Test {

    public static void main(String[] args) {
        Collection collection = new MyCollection();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
