package ecommerce.spring.enties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  Long orderId;
  int quantity;
  String productName;
  BigDecimal prince;
  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  OderEnum oderEnum = OderEnum.COMPLETED;
}
