package ecommerce.spring.controller;

import ecommerce.spring.dto.request.OrderDetailRequest;
import ecommerce.spring.dto.request.OrderRequest;
import ecommerce.spring.dto.response.OrderDetailDto;
import ecommerce.spring.dto.response.OrderDetailResponse;
import ecommerce.spring.enties.Orders;
import ecommerce.spring.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-detail")
@CrossOrigin
public class OrderDetailController {
  @Autowired
  OrderDetailService orderDetailService;
  @GetMapping("/{id}")
  public List<OrderDetailResponse> getAll(@PathVariable("id") Long id){
    return orderDetailService.getByOrderId(id);
  }
  @PostMapping(path = "")
  public OrderDetailDto save(@RequestBody OrderDetailRequest request) {
    return orderDetailService.create(request);
  }

  @PutMapping("/update}")
  public OrderDetailDto update(@RequestBody OrderDetailRequest request) {
    return orderDetailService.update(request);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id) {
    orderDetailService.delete(id);
  }

}
