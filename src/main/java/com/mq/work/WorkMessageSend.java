package com.mq.work;

import com.mq.OkMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkMessageSend {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  public void sendWorkMessage() {
    for (int i = 0; i < 10; i++) {
      rabbitTemplate.convertAndSend("rabbit_work_queue", new OkMessage(i, i + "Work模式"));
    }
  }

}
