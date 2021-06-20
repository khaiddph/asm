package ecommerce.spring.controller;

import ecommerce.spring.dto.request.SignUpRequest;
import ecommerce.spring.dto.response.UserResponse;
import ecommerce.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
  @Autowired
  UserService userService;
  @GetMapping(path = "")
  public List<UserResponse> getAll(){
    return userService.getAll();
  }
  @GetMapping("/{username}")
  public UserResponse getByUsername(@PathVariable("username") String username){
    return userService.getUserByUsername(username);
  }
  @PutMapping("/{id}")
  public UserResponse update(@RequestBody SignUpRequest request,@PathVariable("id") Long id){
    return userService.update(id, request);
  }
  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id){
    userService.delete(id);
  }
}
