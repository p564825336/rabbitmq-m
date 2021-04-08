package com.mq.confirm;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConfirmMessageReceive {

  @RabbitListener(queues = "queue_confirm")
  public void receiveMsg(User user) {
    System.out.println("confirm接收到的消息为：" + user);
  }
}
