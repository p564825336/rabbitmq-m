package com.mq.confirm;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.stereotype.Component;

// 配置 confirm 机制
@Component
public class MyConfirmCallback implements ConfirmCallback {

  /**
   * @param correlationData 消息相关的数据，一般用于获取 唯一标识 id
   * @param ack true 消息确认成功，false 失败
   * @param cause 确认失败的原因
   */
  @Override
  public void confirm(CorrelationData correlationData, boolean ack, String cause) {
    if (ack) {
      System.out.println("confirm 消息确认成功..." + correlationData.getId());
    } else {
      System.out.println("confirm 消息确认失败..." + correlationData.getId() + " cause: " + cause);
    }
  }
}
