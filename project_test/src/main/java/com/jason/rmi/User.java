package com.jason.rmi;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 王政
 * @date 2022/7/22 16:50
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String skill;

}
