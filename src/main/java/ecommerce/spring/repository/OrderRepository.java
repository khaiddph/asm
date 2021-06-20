package ecommerce.spring.repository;

import ecommerce.spring.enties.OderEnum;
import ecommerce.spring.enties.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Long>, OderRepositoryCustom {
  Optional<Orders> findByUserIdAndStatus(Long userId, OderEnum oderEnum);

  List<Orders> findAllByUserIdAndStatus(Long userId, OderEnum oderEnum);

  // @Query("SELECT p FROM Orders p WHERE CONCAT(p.title, p.price, p.totalPrice)
  // LIKE %?1%")
  // Page<Orders> getOrders(@Param(value = "keyword") String keyword, Pageable
  // pageable);

  // Page<Orders> findOrderByAccount(final String user_name, Pageable pageable);

}
