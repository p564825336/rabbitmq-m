package com.mq;

import com.mq.confirm.ConfirmMessageSend;
import com.mq.fanout.FanoutMessageSend;
import com.mq.simple.SimpleMessageSend;
import com.mq.topic.TopicMessageSend;
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

  @Autowired
  private FanoutMessageSend fanoutMessageSend;

  @Autowired
  private TopicMessageSend topicMessageSend;

  @Autowired
  private ConfirmMessageSend confirmMessageSend;


  @Test
  void simpleTest() {
//    simpleMessageSend.sendEasyMessage();
//    simpleMessageSend.sendEasyMessage2();
  }

  @Test
  void workTest() {
//    workMessageSend.sendWorkMessage();
  }

  @Test
  void fanoutTest() {
    fanoutMessageSend.sendFanoutMessage();
  }

  @Test
  void topicTest() {
    topicMessageSend.sendTopicMessage();
  }


  @Test
  void confirmTest() {
    confirmMessageSend.sendConfirmMessage();
  }



}
