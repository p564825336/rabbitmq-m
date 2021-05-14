package com.mq.controller;

import com.mq.dead.message.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

  @Autowired
  public MessageSender messageSender;

  //死信队列controller
  @GetMapping("/send")
  public String send(@RequestParam String msg, Integer time) {
    messageSender.send(msg, time);
    return "ok";
  }

  //延迟插件controller
  @GetMapping("/send2")
  public String sendByPlugin(@RequestParam String msg, Integer time) {
    messageSender.send2(msg, time);
    return "ok";
  }
}
