package com.archforce.ath.rds.service;

import com.archforce.ath.rds.exception.RDSException;
import com.archforce.ath.rds.model.qo.AddUserInfoParams;

public interface UserService {

    /**
     * 新增用户信息
     * @param params
     */
    long addUserInfo(AddUserInfoParams params);
}
