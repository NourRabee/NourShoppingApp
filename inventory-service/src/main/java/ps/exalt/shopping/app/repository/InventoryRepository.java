////////////////////////////////////////////////
//          author: Nour
//          filename: InventoryRepository.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ps.exalt.shopping.app.model.Inventory;

import java.util.List;


@Repository
public interface InventoryRepository extends MongoRepository<Inventory,String> {

    boolean existsBySkuCode(String skuCode);
    Inventory readBySkuCode(String skuCode);
}
