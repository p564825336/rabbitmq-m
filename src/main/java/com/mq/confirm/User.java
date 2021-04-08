package com.mq.confirm;

import java.io.Serializable;

public class User implements Serializable {

  private int i;

  private String km;

  private String km123;

  public User(int i, String km, String km123) {
    this.i = i;
    this.km = km;
    this.km123 = km123;
  }

  @Override
  public String toString() {
    return "User{" +
        "i=" + i +
        ", km='" + km + '\'' +
        ", km123='" + km123 + '\'' +
        '}';
  }
}
