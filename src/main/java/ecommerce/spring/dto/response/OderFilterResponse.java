package ecommerce.spring.dto.response;

import ecommerce.spring.enties.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OderFilterResponse {
  List<Orders> orders;
  int totalRecord;
  int pageIndex;
  int pageSize;
}
