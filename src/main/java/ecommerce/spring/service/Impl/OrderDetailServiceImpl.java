//package ecommerce.spring.service.Impl;
//
//import ecommerce.spring.dto.request.OrderDetailRequest;
//import ecommerce.spring.dto.response.OrderDetailDto;
//import ecommerce.spring.dto.response.OrderDetailResponse;
//import ecommerce.spring.enties.OrderDetail;
//import ecommerce.spring.repository.OrderDetailRepository;
//import ecommerce.spring.repository.OrderRepository;
//import ecommerce.spring.service.OrderDetailService;
//import ecommerce.spring.service.ProductService;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//@Service
//public class OrderDetailServiceImpl implements OrderDetailService {
//  @Autowired
//  OrderRepository orderRepository;
//  @Autowired
//  OrderDetailRepository orderDetailRepository;
//  @Autowired
//  ProductService productService;
//  @Override
//  public List<OrderDetailResponse> getByOrderId(Long orderId) {
//    ModelMapper mapper=new ModelMapper();
//    List<OrderDetail> orderDetails=orderDetailRepository.getAllByOderId(orderId);
//    List<OrderDetailResponse> orderDetailResponses=new ArrayList<>();
//    if (orderDetails.isEmpty()){
//      throw new RuntimeException("order not found");
//    }
//    for (OrderDetail orderDetail: orderDetails){
//      OrderDetailResponse orderDetailResponse=mapper.map(orderDetail,OrderDetailResponse.class);
//      orderDetailResponses.add(orderDetailResponse);
//    }
//    return orderDetailResponses;
//  }
//
//  @Override
//  public OrderDetailDto create(OrderDetailRequest request) {
//    return null;
//  }
//
//  @Override
//  public OrderDetailDto update(Long id, OrderDetailRequest request) {
//    return null;
//  }
//
//  @Override
//  public void delete(Long id) {
//
//  }
//
//  @Override
//  public BigDecimal checkout(Long orderId) {
//    return null;
//  }
//}
