package com.mq.confirm;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfirmMqConfig {

  // 测试confirm 机制，专门创建了一个队列
  @Bean
  public Queue queueConfirm() {
    return new Queue("queue_confirm");
  }

}
