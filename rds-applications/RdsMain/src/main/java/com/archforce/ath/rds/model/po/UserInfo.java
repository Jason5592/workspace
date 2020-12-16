package com.archforce.ath.rds.model.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 42L;

    /**
     * 用户ID
     */
    private long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 创建时间
     */
    private Date ctime;
}
