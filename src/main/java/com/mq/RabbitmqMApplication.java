package com.mq;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = "com.mq")
public class RabbitmqMApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(RabbitmqMApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("mq微服务启动了......");
  }
}
