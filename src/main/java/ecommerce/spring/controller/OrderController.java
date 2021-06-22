package ecommerce.spring.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import ecommerce.spring.dto.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.spring.enties.Orders;
import ecommerce.spring.repository.OrderRepository;
import ecommerce.spring.service.Impl.OrderServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping(path = "")
    public List<Orders> getOrders( ) {
        return this.orderRepository.findAll();
    }

    @PostMapping(path = "")
    public Orders save(@RequestBody Long userId) {
        return orderServiceImpl.create(userId);
    }

    @PutMapping("/{order_id}")
    public Orders updateOrderToAccount(@RequestBody OrderRequest request) {
        return this.orderServiceImpl.update(request);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable("id") Long id) {
        this.orderServiceImpl.delete(id);
    }
}
