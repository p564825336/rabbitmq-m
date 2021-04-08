package com.mq.fanout;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutMessageSend {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  public void sendFanoutMessage() {
    for (int i = 0; i < 5; i++) {
      rabbitTemplate.convertAndSend("fanout_exchange", "", "测试发布订阅模型：" + i);
    }
  }

}
