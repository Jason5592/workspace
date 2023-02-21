package com.jason.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author 王政
 * @date 2022/7/22 16:58
 */
public class RmiClient {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        UserService userService = (UserService) Naming.lookup("rmi://localhost:1900/user");
        User user = userService.findUser(1);
        System.out.println(user);
    }

}
