package ecommerce.spring.controller;

import ecommerce.spring.dto.request.LoginRequest;
import ecommerce.spring.dto.request.SignUpRequest;
import ecommerce.spring.dto.response.JwtResponse;
import ecommerce.spring.dto.response.UserResponse;
import ecommerce.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthenticateController {
  @Autowired
  UserService userService;
  @PostMapping("/login")
  public JwtResponse login(@RequestBody LoginRequest request){
    return userService.signin(request);
  }
  @PostMapping("/signup")
  public UserResponse registerUser(@RequestBody SignUpRequest request){
    return userService.create(request);
  }
}
