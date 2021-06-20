package ecommerce.spring.service.Impl;

import ecommerce.spring.Security.Jwt.JwtUtils;
import ecommerce.spring.dto.request.LoginRequest;
import ecommerce.spring.dto.request.SignUpRequest;
import ecommerce.spring.dto.response.JwtResponse;
import ecommerce.spring.dto.response.UserResponse;
import ecommerce.spring.enties.User;
import ecommerce.spring.repository.UserRepository;
import ecommerce.spring.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserRepository userRepository;
  @Autowired
  PasswordEncoder passwordEncoder;
  @Qualifier("authenticationManagerBean")
  @Autowired
  AuthenticationManager authenticationManager;
  @Autowired
  JwtUtils jwtUtils;

  @Override
  public UserResponse getUserByUsername(String username) {
    Optional<User> userOptional=userRepository.findByUsername(username);
    if (!userOptional.isPresent()){
      throw new RuntimeException("user not found :"+username);
    }
    User user=userOptional.get();
    return new ModelMapper().map(user,UserResponse.class);
  }

  @Override
  public List<UserResponse> getAll() {
    ModelMapper mapper=new ModelMapper();
    List<User> users=userRepository.findAll();
    List<UserResponse> userResponses=new ArrayList<>();
    for (User user : users){
      UserResponse userResponse=mapper.map(user,UserResponse.class);
      userResponses.add(userResponse);
    }
    return userResponses;
  }

  @Override
  public UserResponse create(SignUpRequest request) {

    boolean ex=userRepository.existsByUsernameAndEmail(request.getUsername(), request.getEmail());
    if (ex){
      throw new RuntimeException("exists name and email");
    }
    ModelMapper mapper=new ModelMapper();
    User user=mapper.map(request,User.class);
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    userRepository.save(user);
    return new ModelMapper().map(user,UserResponse.class);
  }

  @Override
  public UserResponse update(Long id, SignUpRequest request) {
    User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("user not found"+ id));
    user.setEmail(request.getEmail());
    user.setName(request.getUsername());
    user.setPhone(request.getPhone());
    user.setUsername(request.getUsername());
    user.setPassword(request.getPassword());
    userRepository.save(user);
    return new ModelMapper().map(user,UserResponse.class);
  }

  @Override
  public void delete(Long id) {
    User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("user not found"+ id));
    userRepository.deleteById(user.getId());
  }

  @Override
  public UserResponse findById(Long id) {
    User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("user not found"+ id));
    return new ModelMapper().map(user,UserResponse.class);
  }

  @Override
  public JwtResponse signin(LoginRequest request) {
    Authentication authentication=authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt= jwtUtils.generateJwtToken(authentication);
    UserResponse userResponse=getUserByUsername(request.getUsername());
    return new JwtResponse(jwt,userResponse);
  }
}
