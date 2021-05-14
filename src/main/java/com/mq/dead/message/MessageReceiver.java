package com.mq.dead.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageReceiver {

  @RabbitHandler
  @RabbitListener(queues = DeadMessageMqConfig.DLK_QUEUE)
  public void onMessage(Message message) {
    log.info("使用死信队列，收到消息:{}", new String(message.getBody()));
  }

  @RabbitHandler
  @RabbitListener(queues = DeadMessageMqConfig.DMP_QUEUE)
  public void onMessage2(Message message) {
    log.info("使用延迟插件，收到消息:{}", new String(message.getBody()));
  }
}
