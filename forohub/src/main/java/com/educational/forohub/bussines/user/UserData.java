package com.educational.forohub.bussines.user;

public record UserData(String name) {

  public UserData(User user) {
    this(
            user.getName()
    );
  }

}
