package com.mq;

import com.mq.simple.EasyMessageSend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqMApplicationTests {

  @Autowired
  private EasyMessageSend easyMessageSend;

  @Test
  void contextLoads() {
    easyMessageSend.sendEasyMessage2();
  }



}
