package ecommerce.spring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderFilterRequest {
  Long userId;
  Long orderId;
  int pageIndex=1;
  int pageSize=5;

}
