package com.mq;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


/**
 * <h1>RabbitMq配置启动类</h1>
 *
 * @author gw
  * @version 1.0
 * @since JDK 1.8
 */
@Configuration
public class RabbitConfiguration {

  @Value("${spring.rabbitmq.host}")
  private String host;
  @Value("${spring.rabbitmq.port}")
  private Integer port;
  @Value("${spring.rabbitmq.virtualhost}")
  private String virtualHost;
  @Value("${spring.rabbitmq.username}")
  private String userName;
  @Value("${spring.rabbitmq.password}")
  private String password;



  @Primary
  @Bean(name = "wenWenConnectionFactory")
  public ConnectionFactory wenWenConnectionFactory() {
    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
    connectionFactory.setHost(host);
    connectionFactory.setPort(port);
    connectionFactory.setVirtualHost(virtualHost);
    connectionFactory.setUsername(userName);
    connectionFactory.setPassword(password);
    return connectionFactory;
  }





}