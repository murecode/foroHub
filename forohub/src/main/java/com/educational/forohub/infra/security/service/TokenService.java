package com.educational.forohub.infra.security.service;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
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

  //Extraer el nombre de usuario del JWT para verificacion
  public String extractSubject(String jwt) {
    // Verificamos que el token no esté vacio
    if(jwt == null) {
      throw new RuntimeException();
    }

    DecodedJWT jwtVerifier = null;
    try {
      Algorithm algorithm = Algorithm.HMAC256(apiSecret); // validando la firma del token
      jwtVerifier  = JWT.require(algorithm)
              .withIssuer("forohub")
              .build()
              .verify(jwt);
      jwtVerifier.getSubject();
    } catch (JWTVerificationException exeption) {
      System.out.println(exeption.toString());
    }

    if (jwtVerifier == null) {
      throw new RuntimeException("Invalid verification");
    }

    return jwtVerifier.getSubject();
  }


  private Instant tokenExpirationTime() {
    return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-05:00"));  //1.
  }



}

//DOCS:

/*1. Establece el tiempo de caducacion del token */
