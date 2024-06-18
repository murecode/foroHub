package com.educational.forohub.infra.security.service;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.educational.forohub.infra.security.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
  @Value("${api.security.secret}")
  private String apiSecret;

  public String createJWT(User user) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(apiSecret);
      return JWT.create()
              .withIssuer("forohub")
              .withSubject(user.getUsername())
              .withClaim("id", user.getId())
              .withExpiresAt(tokenExpirationTime())
              .sign(algorithm);
    } catch (JWTCreationException exeption) {
      throw new RuntimeException();
    }
  }


  private Instant tokenExpirationTime() {
    return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-05:00"));  //1.
  }

}

//DOCS:

/*1. Establece el tiempo de caducacion del token */
