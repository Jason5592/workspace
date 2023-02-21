package com.jason.mapper;

import com.jason.model.User;

/**
 * @author 王政
 * @date 2022/7/25 14:46
 */
public interface UserMapper {

    User queryUserInfoById(long id);

}
