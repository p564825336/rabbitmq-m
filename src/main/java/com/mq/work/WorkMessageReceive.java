package com.mq.work;

import com.mq.OkMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkMessageReceive {

  @RabbitListener(queues = "rabbit_work_queue")
  public void work1(OkMessage message) {
    System.out.println("消费者1--work--接收到车车消息: " + message);
  }

  @RabbitListener(queues = "rabbit_work_queue")
  public void work2(OkMessage message) {
    System.out.println("消费者2--work--接收到车车消息: " + message);
  }

  @RabbitListener(queues = "rabbit_work_queue")
  public void work3(OkMessage message) {
    System.out.println("消费者3--work--接收到车车消息: " + message);
  }

}
