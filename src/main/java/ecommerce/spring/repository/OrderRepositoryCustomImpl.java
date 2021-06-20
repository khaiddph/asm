//package ecommerce.spring.repository;
//
//import ecommerce.spring.dto.request.OrderFilterRequest;
//import ecommerce.spring.dto.response.OderFilterResponse;
//import ecommerce.spring.enties.OderEnum;
//import ecommerce.spring.enties.Orders;
//import org.hibernate.criterion.Order;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import java.util.ArrayList;
//import java.util.List;
//
//public class OrderRepositoryCustomImpl implements OderRepositoryCustom{
//  @PersistenceContext
//  private EntityManager entityManager;
//  @Override
//  public OderFilterResponse filterOder(OrderFilterRequest request) {
//    CriteriaBuilder cb=entityManager.getCriteriaBuilder();
//    CriteriaQuery<Orders> query= cb.createQuery(Orders.class);
//    Root<Orders> orders= query.from(Orders.class);
//    List<Predicate> predicates=new ArrayList<>();
//    if (request.getOrderId() !=null){
//      Predicate orderId=cb.equal(orders.get("id"),request.getOrderId());
//      predicates.add(orderId);
//    }
//    if (request.getUserId()!= null){
//      Predicate userId=cb.equal(orders.get("userId"),request.getUserId());
//      predicates.add(userId);
//    }
//    Predicate status=cb.equal(orders.get("status"), OderEnum.COMPLETED);
//    predicates.add(status);
//    query.orderBy(cb.asc(orders.get("createdDate"))).select(orders)
//        .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
//    int firstResult= request.getPageSize()* (request.getPageIndex()-1);
//    int maxResult=request.getPageSize();
//    List<Orders> ordersList=entityManager.createQuery(query)
//        .setFirstResult(firstResult)
//        .setMaxResults(maxResult)
//        .getResultList();
//    int count=entityManager.createQuery(query).getResultList().size();
//  OderFilterResponse oderFilterResponse=new OderFilterResponse(ordersList,count,request.getPageIndex(),request.getPageSize());
//    return oderFilterResponse;
//  }
//}
