package ecommerce.spring.service;

import ecommerce.spring.dto.request.LoginRequest;
import ecommerce.spring.dto.request.SignUpRequest;
import ecommerce.spring.dto.response.JwtResponse;
import ecommerce.spring.dto.response.UserResponse;

import java.util.List;

public interface UserService {
  UserResponse getUserByUsername(String username);
  List<UserResponse> getAll();
  UserResponse create(SignUpRequest request);
  UserResponse update(Long id,SignUpRequest request);
  void delete(Long id);
  UserResponse findById(Long id);
  JwtResponse signin(LoginRequest request);
}
