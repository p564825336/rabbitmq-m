package com.mq;

import com.mq.simple.SimpleMessageSend;
import com.mq.work.WorkMessageSend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqMApplicationTests {

  @Autowired
  private SimpleMessageSend simpleMessageSend;

  @Autowired
  private WorkMessageSend workMessageSend;

  @Test
  void simpleTest() {
//    simpleMessageSend.sendEasyMessage();
//    simpleMessageSend.sendEasyMessage2();
  }

  @Test
  void workTest() {
    workMessageSend.sendWorkMessage();
  }



}
