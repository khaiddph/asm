package ecommerce.spring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
  Long id;
  Long orderId;
  int quantity;
  BigDecimal price;
  BigDecimal totalPrice;
  String productName;
}
