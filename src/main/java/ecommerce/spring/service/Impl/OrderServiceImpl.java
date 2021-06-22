package ecommerce.spring.service.Impl;

import ecommerce.spring.dto.request.OrderFilterRequest;
import ecommerce.spring.dto.request.OrderRequest;
import ecommerce.spring.dto.response.OderFilterResponse;
import ecommerce.spring.enties.OderEnum;
import ecommerce.spring.enties.Orders;
import ecommerce.spring.repository.OrderRepository;
import ecommerce.spring.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrdersService {
  @Autowired
  OrderRepository orderRepository;

  @Override
  public Orders create(Long userId) {
    Optional<Orders> optionalOrders = orderRepository.findByUserIdAndStatus(userId, OderEnum.INCOMPLETE);
    if (optionalOrders.isPresent()) {
      return optionalOrders.get();
    } else {
      try {
        Orders orders = new Orders();
        orders.setUserId(userId);
        orders.setStatus(OderEnum.INCOMPLETE);
        orders.setCreatedDate(new Date());
        return orderRepository.save(orders);
      } catch (Exception e) {
        throw new RuntimeException("create fail" + e.getMessage());
      }
    }

  }

  @Override
  public Orders update(OrderRequest request) {
    Orders orders=orderRepository.findByUserIdAndStatus(request.getUserId(), OderEnum.INCOMPLETE).orElseThrow(()-> new RuntimeException("order not found"));
    orders.setTotalPrice(request.getPrince());
    orders.setStatus(request.getStatus());
    return orderRepository.save(orders);
  }

  @Override
  public List<Orders> findByUserId(Long id) {
    return orderRepository.findAllByUserIdAndStatus(id,OderEnum.COMPLETED);
  }

  @Override
  public void delete(Long id) {
  Orders orders=orderRepository.findById(id).orElseThrow(()-> new RuntimeException("order not found"));
  orderRepository.deleteById(orders.getId());
  }

  @Override
  public List<Orders> filter() {
    return orderRepository.findAll();
  }
}
