////////////////////////////////////////////////
//          author: Nour
//          filename: OrderRepository.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ps.exalt.shopping.app.model.Order;


@Repository
public interface OrderRepository extends MongoRepository<Order,String> {



}
