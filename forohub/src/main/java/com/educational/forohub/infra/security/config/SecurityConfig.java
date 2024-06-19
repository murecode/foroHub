package com.educational.forohub.infra.security.config;

import com.educational.forohub.infra.security.config.filter.SecurityAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity //1.
public class SecurityConfig {

  @Autowired
  private SecurityAuthFilter securityAuthFilter;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity.csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .addFilterBefore(securityAuthFilter, UsernamePasswordAuthenticationFilter.class)
            .authorizeHttpRequests((authorize) -> {

              authorize.requestMatchers(HttpMethod.POST, "/auth/login").permitAll();
              authorize.anyRequest().authenticated();

            })
            .build();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}

//DOCS:
/*1. Habilita la config de seguridad web en la app. Extiende WebSecurityConfigurerAdapter.
  activa la integración de Sprng Scrty con Sprng MVC y proporciona un punto de entrada para
  personalizar la configuración de seguridad web.*/
