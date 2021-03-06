package ecommerce.spring.Security.Jwt;

import ecommerce.spring.Security.service.UserDetailImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthTokenFilter extends OncePerRequestFilter {
  private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);
  @Autowired
  JwtUtils jwtUtils;
  @Autowired
  UserDetailImpl userDetailImpl;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    try {
      String jwt = parseJwt(request);
      if (jwt != null && jwtUtils.validateToken(jwt)) {
        String username = jwtUtils.getUsernameByJwt(jwt);
        UserDetails userDetail = userDetailImpl.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
      }
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    filterChain.doFilter(request, response);

  }

  private String parseJwt(HttpServletRequest request) {
    String headAuth = request.getHeader("Authorization");
    if (StringUtils.hasText(headAuth) && headAuth.startsWith("Bearer")) {
      return headAuth.substring(7, headAuth.length());
    }
    return null;
  }
}
