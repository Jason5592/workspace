package com.jason.design.bridge;

/**
 * @author 王政
 * @date 2022/8/31 10:53
 */
public class Test {

    public static void main(String[] args) {
        Bridge bridge = new MyBridge();

        Source source1 = new Source1();
        bridge.setSource(source1);
        bridge.method();

        Source source2 = new Source2();
        bridge.setSource(source2);
        bridge.method();

    }

}
