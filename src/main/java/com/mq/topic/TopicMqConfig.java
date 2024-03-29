package com.mq.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicMqConfig {

  // topic 模型
  @Bean
  public Queue queueTopic1() {
    return new Queue("queue_topic1");
  }

  @Bean
  public Queue queueTopic2() {
    return new Queue("queue_topic2");
  }

  @Bean
  public TopicExchange exchangeTopic() {
    return new TopicExchange("topic_exchange");
  }

  @Bean
  public Binding bindingTopic1() {
    //符号“#”匹配路由键的一个或多个词
    return BindingBuilder.bind(queueTopic1()).to(exchangeTopic()).with("topic.#");
  }

  @Bean
  public Binding bindingTopic2() {
    //符号“*”匹配路由键的一个词
    return BindingBuilder.bind(queueTopic2()).to(exchangeTopic()).with("topic.*");
  }

}
