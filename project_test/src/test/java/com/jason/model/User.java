package com.jason.model;


import lombok.Data;

/**
 * @author 王政
 * @date 2022/7/25 14:46
 */
@Data
public class User {

    private Integer id;

    public String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
