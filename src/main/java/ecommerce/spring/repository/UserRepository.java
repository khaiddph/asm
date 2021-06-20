package ecommerce.spring.repository;

import ecommerce.spring.enties.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
  Optional<User> findByUsername(String username);
  boolean existsByUsernameAndEmail(String username,String email);
}
