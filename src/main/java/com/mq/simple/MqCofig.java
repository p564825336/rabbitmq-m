package com.mq.simple;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqCofig {

  /**
   * 简单模式: 一个生产者，一个消费者
   * @return
   */
  @Bean
  public Queue easyQueue() {
    return new Queue("rabbit_easy_queue");
  }
}
