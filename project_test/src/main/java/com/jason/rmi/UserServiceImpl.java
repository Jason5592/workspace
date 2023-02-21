package com.jason.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author 王政
 * @date 2022/7/22 16:51
 */
public class UserServiceImpl extends UnicastRemoteObject implements UserService {


    protected UserServiceImpl() throws RemoteException {

    }

    @Override
    public User findUser(int userId) throws RemoteException {
        if (userId == 1) {
            User user = new User();
            user.setId(1);
            user.setName("金庸");
            user.setSkill("写作");
            return user;
        }

        throw new RemoteException("查无此人");
    }

}
