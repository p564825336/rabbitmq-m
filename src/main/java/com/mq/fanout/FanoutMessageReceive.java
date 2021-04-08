package com.mq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutMessageReceive {

  @RabbitListener(queues = "rabbit_fanout_queue_one")
  public void receiveMsg1(String msg) {
    System.out.println("发布订阅测试-----队列1接收到消息：" + msg);
  }

  @RabbitListener(queues = "rabbit_fanout_queue_two")
  public void receiveMsg2(String msg) {
    System.out.println("发布订阅测试-----队列2接收到消息：" + msg);
  }

}
