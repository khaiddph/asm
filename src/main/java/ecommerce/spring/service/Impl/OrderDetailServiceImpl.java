package ecommerce.spring.service.Impl;

import ecommerce.spring.dto.request.OrderDetailRequest;
import ecommerce.spring.dto.response.OrderDetailDto;
import ecommerce.spring.dto.response.OrderDetailResponse;
import ecommerce.spring.enties.OderEnum;
import ecommerce.spring.enties.OrderDetail;
import ecommerce.spring.repository.OrderDetailRepository;
import ecommerce.spring.repository.OrderRepository;
import ecommerce.spring.service.OrderDetailService;
import ecommerce.spring.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
  @Autowired
  OrderRepository orderRepository;
  @Autowired
  OrderDetailRepository orderDetailRepository;
  @Autowired
  ProductService productService;

  @Override
  public List<OrderDetailResponse> getByOrderId(Long orderId) {
    ModelMapper mapper = new ModelMapper();
    List<OrderDetail> orderDetails = orderDetailRepository.getAllByOrderId(orderId);
    List<OrderDetailResponse> orderDetailResponses = new ArrayList<>();
    if (orderDetails.isEmpty()) {
      throw new RuntimeException("order not found");
    }
    for (OrderDetail orderDetail : orderDetails) {
      OrderDetailResponse orderDetailResponse = mapper.map(orderDetail, OrderDetailResponse.class);
      orderDetailResponses.add(orderDetailResponse);
    }
    return orderDetailResponses;
  }

  @Override
  public OrderDetailDto create(OrderDetailRequest request) {
    ModelMapper mapper = new ModelMapper();
    OrderDetail orderDetail = mapper.map(request, OrderDetail.class);
    orderDetail.setStatus(OderEnum.INCOMPLETE);
    orderDetailRepository.save(orderDetail);
    return new ModelMapper().map(orderDetail, OrderDetailDto.class);
  }

  @Override
  public OrderDetailDto update( OrderDetailRequest request) {
    OrderDetail orderDetail = orderDetailRepository.findByProductNameAndOrderId(request.getProductName(), request.getOrderId())
        .orElseThrow(() -> new RuntimeException("order not found"));
    orderDetail.setPrince(request.getPrice());
    orderDetail.setQuantity(request.getQuantity());
    orderDetailRepository.save(orderDetail);
    return new ModelMapper().map(orderDetail, OrderDetailDto.class);
  }

  @Override
  public void delete(Long id) {
    OrderDetail orderDetail = orderDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("oder detail not found"));
    orderDetailRepository.delete(orderDetail);
  }

  @Override
  public BigDecimal checkout(Long orderId) {
    return null;
  }
}
