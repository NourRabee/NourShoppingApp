////////////////////////////////////////////////
//          author: Nour
//          filename: Product.java
//          2023
////////////////////////////////////////////////

package ps.exalt.shopping.app.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ps.exalt.shopping.app.common.model.BaseModel;

import java.math.BigDecimal;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@Entity
@Table
public class Product extends BaseModel<String> {
    @Id
    private String id;
    private BigDecimal price;
    private String description;
    @ManyToOne
    private Category category;

}
