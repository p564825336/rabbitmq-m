package com.mq.dead.message;

import java.util.HashMap;
import java.util.Map;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

public class DeadMessageMqConfig {

  //死信交换机，队列，路由相关配置
  public static final String DLK_EXCHANGE = "dlk.exchange";
  public static final String DLK_ROUTEKEY = "dlk.routeKey";
  public static final String DLK_QUEUE = "dlk.queue";

  //业务交换机，队列，路由相关配置
  public static final String DEMO_EXCHANGE = "demo.exchange";
  public static final String DEMO_QUEUE = "demo.queue";
  public static final String DEMO_ROUTEKEY = "demo.routeKey";

  //延时插件DelayedMessagePlugin的交换机，队列，路由相关配置
  public static final String DMP_EXCHANGE = "dmp.exchange";
  public static final String DMP_ROUTEKEY = "dmp.routeKey";
  public static final String DMP_QUEUE = "dmp.queue";

  @Bean
  public DirectExchange demoExchange() {
    return new DirectExchange(DEMO_EXCHANGE, true, false);
  }

  @Bean
  public Queue demoQueue() {
    //只需要在声明业务队列时添加x-dead-letter-exchange，值为死信交换机
    Map<String, Object> map = new HashMap<>(1);
    map.put("x-dead-letter-exchange", DLK_EXCHANGE);
    //该参数x-dead-letter-routing-key可以修改该死信的路由key，不设置则使用原消息的路由key
    map.put("x-dead-letter-routing-key", DLK_ROUTEKEY);
    return new Queue(DEMO_QUEUE, true, false, false, map);
  }

  @Bean
  public Binding demoBind() {
    return BindingBuilder.bind(demoQueue()).to(demoExchange()).with(DEMO_ROUTEKEY);
  }

  @Bean
  public DirectExchange dlkExchange() {
    return new DirectExchange(DLK_EXCHANGE, true, false);
  }

  @Bean
  public Queue dlkQueue() {
    return new Queue(DLK_QUEUE, true, false, false);
  }

  @Bean
  public Binding dlkBind() {
    return BindingBuilder.bind(dlkQueue()).to(dlkExchange()).with(DLK_ROUTEKEY);
  }

  //延迟插件使用
  //1、声明一个类型为x-delayed-message的交换机
  //2、参数添加一个x-delayed-type值为交换机的类型用于路由key的映射
  @Bean
  public CustomExchange dmpExchange() {
    Map<String, Object> arguments = new HashMap<>(1);
    arguments.put("x-delayed-type", "direct");
    return new CustomExchange(DMP_EXCHANGE, "x-delayed-message", true, false, arguments);
  }

  @Bean
  public Queue dmpQueue() {
    return new Queue(DMP_QUEUE, true, false, false);
  }

  @Bean
  public Binding dmpBind() {
    return BindingBuilder.bind(dmpQueue()).to(dmpExchange()).with(DMP_ROUTEKEY).noargs();
  }

}
