package com.educational.forohub.bussines.user;

import com.educational.forohub.infra.security.model.User;

public record UserData(String name) {

  public UserData(User user) {
    this(
            user.getName()
    );
  }

}
