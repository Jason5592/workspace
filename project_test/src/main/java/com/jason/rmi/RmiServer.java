package com.jason.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @author 王政
 * @date 2022/7/22 16:55
 */
public class RmiServer {

    public static void main(String[] args) {
        try {
            UserService userService = new UserServiceImpl();
            LocateRegistry.createRegistry(1900);
            Naming.rebind("rmi://localhost:1900/user", userService);
            System.out.println("start server, port is 1900");
        } catch (Exception e) {
        }
    }

}
