package com.archforce.ath.rds.action;

import com.archforce.ath.rds.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zh_w5 on 2020/12/28.
 */
@RestController
@RequestMapping("/message")
public class MessageController {

  @Autowired
  private MessageService messageService;

  @GetMapping("/send")
  public String send(@RequestParam(value = "msg", name = "msg") String msg) {
    try {
      msg = new String(msg.getBytes(), "utf-8");
    } catch (Exception e) {
    }
    messageService.send(msg);
    return "send[" + msg + "].";
  }
}
