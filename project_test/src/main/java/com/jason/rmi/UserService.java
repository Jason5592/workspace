package com.jason.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author 王政
 * @date 2022/7/22 16:51
 */
public interface UserService extends Remote {

    User findUser(int userId) throws RemoteException;
}
