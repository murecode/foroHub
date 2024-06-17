package com.educational.forohub.infra.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //1.
public class HttpSecurityConfig {
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity.csrf()
            .disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().build();

  }
}

//DOCS:
/*1. Habilita la config de seguridad web en la app. Extiende WebSecurityConfigurerAdapter.
  activa la integración de Sprng Scrty con Sprng MVC y proporciona un punto de entrada para
  personalizar la configuración de seguridad web.*/
