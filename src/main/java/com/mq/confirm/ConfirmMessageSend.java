package com.mq.confirm;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfirmMessageSend {

  @Autowired
  private MyConfirmCallback myConfirmCallback;

  @Autowired
  private RabbitTemplate rabbitTemplate;

  // 测试 confirm机制
  public void sendConfirmMessage() {
    rabbitTemplate.convertAndSend("queue_confirm", new User(1, "km", "km123"), new CorrelationData("config_" + System.currentTimeMillis()));
    rabbitTemplate.setConfirmCallback(myConfirmCallback);
  }

}
