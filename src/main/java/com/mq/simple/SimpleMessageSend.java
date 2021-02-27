package com.mq.simple;

import com.mq.OkMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleMessageSend {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  public void sendEasyMessage() {
    for (int i = 0; i < 10; i++) {
      rabbitTemplate.convertAndSend("rabbit_easy_queue", new OkMessage(i, i + "简单模式"));
    }
  }


  public void sendEasyMessage2() {
    for (int i = 0; i < 10; i++) {
      rabbitTemplate.convertSendAndReceive("rabbit_easy_queue", new OkMessage(i, i + "简单模式"));
    }
  }
}
