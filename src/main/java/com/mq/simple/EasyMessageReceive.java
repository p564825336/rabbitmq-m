package com.mq.simple;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EasyMessageReceive {

  @RabbitListener(queues = "rabbit_easy_queue")
  @RabbitHandler
  public void process(EasyMessage easyMessage) throws InterruptedException {
    System.out.println("-------------------------------------------");
    Thread.sleep(10000);
    System.out.println("接收一, 简单消费者接收到消息: " + easyMessage);
  }


  @RabbitListener(queues = "rabbit_easy_queue")
  @RabbitHandler
  public void process2(EasyMessage easyMessage) {
    System.out.println("接收二, 简单消费者接收到消息: " + easyMessage);
  }


}
