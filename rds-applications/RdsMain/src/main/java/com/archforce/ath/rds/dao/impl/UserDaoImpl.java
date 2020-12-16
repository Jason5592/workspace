package com.archforce.ath.rds.dao.impl;

import com.archforce.ath.rds.dao.UserDao;
import com.archforce.ath.rds.model.po.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

@Slf4j
@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    @Qualifier("jdbcTemplateOne")
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserInfo queryUserInfo(long userId) {
        String sql = "SELECT * FROM pt_user_info WHERE User_ID = ?";
        List<UserInfo> userInfos = jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(UserInfo.class));
        return userInfos.get(0);
    }

    @Override
    public long insertUserInfo(UserInfo userInfo) {
        String sql = "INSERT INTO pt_user_info(User_Name, CTime)" +
                "VALUES(?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"User_Name", "CTime"});
            ps.setString(1, userInfo.getUsername());
            ps.setDate(2, new Date(userInfo.getCtime().getTime()));
            return ps;
        };

        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        Number primaryKey = keyHolder.getKey();
        if (primaryKey == null) {
            log.error("insert pt_user_info failed! UserInfo[" + userInfo + "].");
            throw new RuntimeException();
        }
        return primaryKey.longValue();
    }
}
