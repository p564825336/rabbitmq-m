package com.mq.dead.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageSender {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  //使用死信队列发送消息方法封装
  public void send(String message, Integer time) {
    String ttl = String.valueOf(time * 1000);
    //exchange和routingKey都为业务的就可以，只需要设置消息的过期时间
    rabbitTemplate.convertAndSend(DeadMessageMqConfig.DEMO_EXCHANGE, DeadMessageMqConfig.DEMO_ROUTEKEY, message, new MessagePostProcessor() {
      @Override
      public Message postProcessMessage(Message message) throws AmqpException {
        //设置消息的过期时间，是以毫秒为单位的
        message.getMessageProperties().setExpiration(ttl);
        return message;
      }
    });

    log.info("使用死信队列消息:{}发送成功,过期时间:{}秒。", message, time);
  }

  //使用延迟插件发送消息方法封装
  public void send2(String message, Integer time) {
    rabbitTemplate.convertAndSend(DeadMessageMqConfig.DMP_EXCHANGE, DeadMessageMqConfig.DMP_ROUTEKEY, message, new MessagePostProcessor() {
      @Override
      public Message postProcessMessage(Message message) throws AmqpException {
        //使用延迟插件只需要在消息的header中添加x-delay属性，值为过期时间，单位毫秒
        message.getMessageProperties().setHeader("x-delay", time * 1000);
        return message;
      }
    });

    log.info("使用延迟插件发送消息:{}发送成功,过期时间:{}秒。", message, time);
  }
}
