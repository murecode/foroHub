package com.educational.forohub.bussines.user.dtos;

import com.educational.forohub.infra.security.model.User;

public record UserAuthData(
        String username,
        String password
) {
  public UserAuthData(User user) {
    this(
            user.getUsername(),
            user.getPassword()
    );
  }

}
