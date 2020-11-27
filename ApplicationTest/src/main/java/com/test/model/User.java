package com.test.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 42L;

    private long userId;
    private String username;
    private String nickname;
}
