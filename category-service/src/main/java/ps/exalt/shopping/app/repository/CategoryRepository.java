////////////////////////////////////////////////
//          author: Nour
//          filename: CategoryRepository.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ps.exalt.shopping.app.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {

}
