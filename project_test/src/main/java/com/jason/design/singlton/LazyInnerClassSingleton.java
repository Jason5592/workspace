package com.jason.design.singlton;

import org.junit.Assert;

import java.io.*;

/**
 * @author 王政
 * @date 2022/6/6 15:22
 */
public class LazyInnerClassSingleton implements Serializable {

    private static LazyInnerClassSingleton getInstance() {
        return LazyHolder.LAZY_INNER_CLASS_SINGLETON;
    }

    private Object readResolve() {
        return LazyHolder.LAZY_INNER_CLASS_SINGLETON;
    }

    private LazyInnerClassSingleton() {
        if (LazyHolder.LAZY_INNER_CLASS_SINGLETON != null) {
            throw new RuntimeException("不允许的构造操作");
        }
    }

    private static class LazyHolder {
        public static final LazyInnerClassSingleton LAZY_INNER_CLASS_SINGLETON = new LazyInnerClassSingleton();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LazyInnerClassSingleton lazyInnerClassSingleton = LazyInnerClassSingleton.getInstance();
        System.out.println(lazyInnerClassSingleton);

        LazyInnerClassSingleton s1;
        LazyInnerClassSingleton s = LazyInnerClassSingleton.getInstance();

        FileOutputStream fos = new FileOutputStream("a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("a.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s1 = (LazyInnerClassSingleton) ois.readObject();

        Assert.assertEquals(s, s1);
    }

}
