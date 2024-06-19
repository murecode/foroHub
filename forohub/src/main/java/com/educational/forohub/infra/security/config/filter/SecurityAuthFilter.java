package com.educational.forohub.infra.security.config.filter;

import com.educational.forohub.infra.repository.UserRepository;
import com.educational.forohub.infra.security.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityAuthFilter extends OncePerRequestFilter {
  @Autowired
  private TokenService tokenService;
  @Autowired
  private UserRepository userRepo;

  @Override
  protected void doFilterInternal(
          HttpServletRequest request,
          HttpServletResponse response,
          FilterChain filterChain // permite pasar la solicitud y respuesta a través de la cadena de filtros.
  ) throws ServletException, IOException {

    String requestHeader = request.getHeader("Authorization"); // obtiene el valor del encabezado Authorization de la solicitud HTTP.

    if (requestHeader != null && requestHeader.startsWith("Bearer ")) {

      try {

        var jwt = requestHeader.replace("Bearer ", ""); // Si el token no es null y no ha sido manipulado, se elimina el prefijo Bearer del valor del encabezado para obtener el JWT.
        var subject = tokenService.extractSubject(jwt); // extrae el username del subject del JWT.

        if (subject != null && SecurityContextHolder.getContext().getAuthentication() == null) { // verifica que username del subject no sea null y si no hay ninguna autenticación establecida en el contexto de seguridad actual.
          UserDetails userDetails = userRepo.findByUsername(subject); // busca en userRepo el UserDetails correspondiente.
          var subjecAuthenticated = new UsernamePasswordAuthenticationToken(
                  userDetails,
                  null,
                  userDetails.getAuthorities()); // crea un objeto UsernamePasswordAuthenticationToken con los detalles del usuario y sus autoridades (roles/privilegios).
          SecurityContextHolder.getContext().setAuthentication(subjecAuthenticated); // Se establece la autenticación en el contexto de seguridad de Spring
        }
      } catch (Exception exception) {
        logger.error("Error al autenticar el usuario" + exception);
      }
    }
    filterChain.doFilter(request, response); // se pasan al siguiente filtro en la cadena, permitiendo que el procesamiento continúe.
  }

}
