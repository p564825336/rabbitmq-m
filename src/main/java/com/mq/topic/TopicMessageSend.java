package com.mq.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicMessageSend {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  // 向topic模型发送数据
  public void sendTopicMessage() {
    for (int i = 0; i < 10; i++) {
      if (i % 2 == 0) {
        rabbitTemplate.convertSendAndReceive("topic_exchange", "topic.km.topic", "测试Topic模型：" + i);
      } else {
        rabbitTemplate.convertSendAndReceive("topic_exchange", "topic.km", "测试Topic模型：" + i);
      }
    }
  }

}
