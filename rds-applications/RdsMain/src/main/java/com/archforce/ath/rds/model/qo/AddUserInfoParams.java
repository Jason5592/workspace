package com.archforce.ath.rds.model.qo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddUserInfoParams implements Serializable {

    private static final long serialVersionUID = 42L;

    /**
     * 用户名
     */
    private String username;
}
