package com.archforce.ath.rds.service.impl;

import com.archforce.ath.rds.dao.UserDao;
import com.archforce.ath.rds.grpc.proto.UserId;
import com.archforce.ath.rds.grpc.proto.UserServiceGrpc;
import com.archforce.ath.rds.model.po.UserInfo;
import com.archforce.ath.rds.model.qo.AddUserInfoParams;
import com.archforce.ath.rds.service.UserService;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.archforce.ath.rds.ServerConstants.LOGGER_PREFIX;

@GrpcService
@Slf4j
@Service
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public long addUserInfo(AddUserInfoParams params) {
        if (params == null) {
            String message = LOGGER_PREFIX + "[新增用户信息]请求参数为空！";
            log.warn(message);
            throw new RuntimeException(message);
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(params.getUsername());
        userInfo.setCtime(new Date());
        return userDao.insertUserInfo(userInfo);
    }

    @Override
    public void addUserInfo(com.archforce.ath.rds.grpc.proto.AddUserInfoParams request, StreamObserver<UserId> responseObserver) {
        AddUserInfoParams params = new AddUserInfoParams();
        params.setUsername(request.getUsername());
        long userId = addUserInfo(params);
        responseObserver.onNext(UserId.newBuilder().setUserId(userId).build());
        responseObserver.onCompleted();
    }
}
