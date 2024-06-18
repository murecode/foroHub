package com.educational.forohub.bussines.user;

import com.educational.forohub.bussines.user.dtos.UserAuthData;
import com.educational.forohub.infra.security.model.JWTData;
import com.educational.forohub.infra.security.model.User;
import com.educational.forohub.infra.security.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
  @Autowired
  private AuthenticationManager authManager;
  @Autowired
  private TokenService tokenService;

  @PostMapping("/login")
  public ResponseEntity login(@RequestBody @Valid UserAuthData userAuthData) {
    Authentication authToken = new UsernamePasswordAuthenticationToken(
            userAuthData.username(), userAuthData.password());
    var authenticatedUser = authManager.authenticate(authToken);
    var jwtToken = tokenService.createJWT((User) authenticatedUser.getPrincipal());

    return ResponseEntity.ok(new JWTData(jwtToken));
  }

}
