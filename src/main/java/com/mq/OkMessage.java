package com.mq;

import java.io.Serializable;

public class OkMessage implements Serializable {

  private Integer i;

  private String message;

  public OkMessage(Integer i, String message) {
    this.i = i;
    this.message = message;
  }

  @Override
  public String toString() {
    return "OkMessage{" +
        "i=" + i +
        ", message='" + message + '\'' +
        '}';
  }
}
