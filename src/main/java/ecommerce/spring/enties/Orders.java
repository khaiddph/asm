package ecommerce.spring.enties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orders {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  @Column(name = "user_id")
  Long userId;
  BigDecimal totalPrice;
  Date createdDate;
  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  OderEnum status=OderEnum.COMPLETED;

  // private String status;

  // @ManyToOne(fetch = FetchType.EAGER)
  // @JoinColumn(name = "user_name")
  // // @OnDelete(action = OnDeleteAction.CASCADE)
  // private Account account;

  // @JsonIgnore
  // @OneToMany(mappedBy = "orders")
  // private List<OrderDetail> ordersDetails;
}
