package com.mq.simple;

import java.io.Serializable;

public class EasyMessage implements Serializable {

  private Integer i;

  private String message;

  public EasyMessage(Integer i, String message) {
    this.i = i;
    this.message = message;
  }

  @Override
  public String toString() {
    return "EasyMessage{" +
        "i=" + i +
        ", message='" + message + '\'' +
        '}';
  }
}
