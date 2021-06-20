package ecommerce.spring.dto.request;

import ecommerce.spring.enties.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
  String username;
  String password;
  String name;
  String email;
  String phone;
  @Enumerated(EnumType.STRING)
  RoleEnum role;
}
