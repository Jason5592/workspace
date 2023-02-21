package com.jason.design.bridge;

/**
 * @author 王政
 * @date 2022/8/31 10:51
 */
public class Bridge {

    private Source source;

    public void method() {
        source.method();
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

}
