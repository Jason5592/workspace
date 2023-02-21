package com.jason.design.memento;

/**
 * @author 王政
 * @date 2022/8/31 18:25
 */
public class Memento {

    private String value;

    public Memento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
