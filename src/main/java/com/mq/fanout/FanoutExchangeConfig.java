package com.mq.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 发布订阅模式 配置两个队列一个交换机
 */
@Configuration
public class FanoutExchangeConfig {

  /**
   * 队列一
   */
  @Bean
  public Queue FanoutQueueOne() {
    return new Queue("rabbit_fanout_queue_one");
  }

  /**
   * 队列二
   */
  @Bean
  public Queue FanoutQueueTwo() {
    return new Queue("rabbit_fanout_queue_two");
  }

  /**
   * 交换机 声明为FanoutExchange类型
   */
  @Bean
  public FanoutExchange fanoutExchange() {
    return new FanoutExchange("fanout_exchange");
  }

  /**
   * 绑定队列一到交换机
   *
   * @param FanoutQueueOne 上方定义的队列一方法名  根据此方法名参数 器会自动注入对应bean
   * @param fanoutExchange 上方定义的交换机方法名
   */
  @Bean
  public Binding bindingFanoutExchangeA(Queue FanoutQueueOne, FanoutExchange fanoutExchange) {
    return BindingBuilder.bind(FanoutQueueOne).to(fanoutExchange);
  }

  /**
   * 绑定队列二到交换机
   *
   * @param FanoutQueueTwo 上方定义的队列二方法名  根据此方法名参数 器会自动注入对应bean   当 然也可以省略参数 直接在bind中指定队列构建方法名 例如 FanoutQueueTwo()
   * @param fanoutExchange 上方定义的交换机方法名
   */
  @Bean
  public Binding bindingFanoutExchangeB(Queue FanoutQueueTwo, FanoutExchange fanoutExchange) {
    return BindingBuilder.bind(FanoutQueueTwo).to(fanoutExchange);
  }
}
