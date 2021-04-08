package com.mq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicMessageReceive {

  @RabbitListener(queues = "queue_topic1")
  public void receiveMsg1(String msg) {
    System.out.println("Topic消费者1接收到：" + msg);
  }

  @RabbitListener(queues = "queue_topic2")
  public void receiveMsg2(String msg) {
    System.out.println("Topic消费者2接收到：" + msg);
  }

}
