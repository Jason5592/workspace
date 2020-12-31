package com.archforce.ath.rds.action;

import com.archforce.ath.rds.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zh_w5 on 2020/12/28.
 */
@RestController
public class HelloWorldController {

  @Autowired
  private HelloWorldService helloWorldService;

  @GetMapping("/hello")
  public String sayHello(String message) {
    try {
      message = new String(message.getBytes(), "utf-8");
    } catch (Exception e) {
    }
    helloWorldService.sayHello(message);
    return "hello, " + message;
  }

  @GetMapping("/hello1")
  public String sayHello1(String message) {
    try {
      message = new String(message.getBytes(), "utf-8");
    } catch (Exception e) {
    }
    helloWorldService.sayHello1(message);
    return "hello1, " + message;
  }

}
