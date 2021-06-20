package ecommerce.spring.service;

import ecommerce.spring.dto.request.OrderDetailRequest;
import ecommerce.spring.dto.response.OrderDetailDto;
import ecommerce.spring.dto.response.OrderDetailResponse;

import java.math.BigDecimal;
import java.util.List;

public interface OrderDetailService {
    List<OrderDetailResponse> getByOrderId(Long orderId);
    OrderDetailDto create(OrderDetailRequest request);
    OrderDetailDto update(Long id ,OrderDetailRequest request);
    void delete(Long id);
    BigDecimal checkout(Long orderId);
}
