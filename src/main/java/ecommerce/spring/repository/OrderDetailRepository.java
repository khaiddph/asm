package ecommerce.spring.repository;

import ecommerce.spring.enties.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
  List<OrderDetail> getAllByOderId(Long orderId);
  Optional<OrderDetail> findByProductNameAndOrderId(String productName,Long orderId);
}
