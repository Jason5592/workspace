package com.archforce.ath.rds.dao;

import com.archforce.ath.rds.model.po.UserInfo;

public interface UserDao {

    /**
     * 查询用户信息
     * @param userId 用户ID
     * @return 用户信息
     */
    UserInfo queryUserInfo(long userId);

    /**
     * 新增用户信息
     * @param userInfo 用户信息
     * @return 返回自增主键
     */
    long insertUserInfo(UserInfo userInfo);
}
