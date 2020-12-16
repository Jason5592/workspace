package com.archforce.jason.client;

import com.archforce.ath.rds.grpc.proto.AddUserInfoParams;
import com.archforce.ath.rds.grpc.proto.UserId;
import com.archforce.ath.rds.grpc.proto.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class UserServiceClient {

    private static final UserServiceGrpc.UserServiceBlockingStub helloWorldServiceBlockingStub;

    static {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6561).usePlaintext().build();
        helloWorldServiceBlockingStub = UserServiceGrpc.newBlockingStub(managedChannel);
    }

    public long addUserInfo(String username) {
        AddUserInfoParams params = AddUserInfoParams.newBuilder().setUsername(username).build();
        UserId userId = helloWorldServiceBlockingStub.addUserInfo(params);
        return userId.getUserId();
    }

    @Test
    public void test1() {
        UserServiceClient userServiceClient = new UserServiceClient();
        long userId = userServiceClient.addUserInfo("Jason");
        System.out.println(userId);
    }
}
