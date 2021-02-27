package com.mq.work;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkMqConfig {

  /**
   * 工作模式 一个生产者 多个消费者
   * @return
   */
  @Bean
  public Queue workQueue() {
    return new Queue("rabbit_work_queue");
  }
}
