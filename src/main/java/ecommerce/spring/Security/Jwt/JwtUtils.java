package ecommerce.spring.Security.Jwt;

import ecommerce.spring.Security.service.UserDetail;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
  private static final String jwtSecret = "picapi";
  private static final int jwtExpirationMs = 360000;

  public String generateJwtToken(Authentication authentication) {
    UserDetail userPrincipal = (UserDetail) authentication.getPrincipal();
    Date expirationDate = new Date(new Date().getTime() + jwtExpirationMs);
    return Jwts.builder().setSubject(userPrincipal.getUsername())
        .setIssuedAt(new Date())
        .setExpiration(expirationDate)
        .signWith(SignatureAlgorithm.HS512, jwtSecret)
        .compact();
  }

  public String getUsernameByJwt(String token) {
    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
      return true;
    } catch (SignatureException se) {
      logger.error(se.getMessage());
    } catch (MalformedJwtException me) {
      logger.error(me.getMessage());
    } catch (ExpiredJwtException ee) {
      logger.error(ee.getMessage());
    } catch (UnsupportedJwtException ue) {
      logger.error(ue.getMessage());
    } catch (IllegalArgumentException ie) {
      logger.error(ie.getMessage());
    }
    return false;
  }

}
