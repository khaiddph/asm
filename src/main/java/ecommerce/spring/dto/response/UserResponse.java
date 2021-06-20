package ecommerce.spring.dto.response;

import ecommerce.spring.enties.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
  Long id;
  String username;
  String password;
  String name;
  String email;
  String phone;
  RoleEnum role;
}
