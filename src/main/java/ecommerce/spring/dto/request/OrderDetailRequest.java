package ecommerce.spring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetailRequest {
  Long orderId;
  int quantity;
  BigDecimal price;
  BigDecimal totalPrice;
  String productName;
}
