////////////////////////////////////////////////
//          author: Nour
//          filename: ProductRepository.java
//          2023
////////////////////////////////////////////////

package ps.exalt.shopping.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ps.exalt.shopping.app.model.Category;
import ps.exalt.shopping.app.model.Product;

import java.util.List;

// Data Access Layer
@Repository
public interface ProductRepository extends JpaRepository<Product,String> {

    public abstract List<Product> findByid(String id);

    public abstract List<Product> findByIdAndCategory(String id, Category category);

    public abstract List<Product> findByCategory(Category category);
}
