package ecommerce.spring.dto.request;

import ecommerce.spring.enties.OderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
  Long userId;
  BigDecimal prince;
  OderEnum status;
}
