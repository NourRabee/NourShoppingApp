////////////////////////////////////////////////
//          author: Nour
//          filename: Product.java
//          2023
////////////////////////////////////////////////

package ps.exalt.shopping.app.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

import java.math.BigDecimal;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@Entity
@Table
public class Product {

    private String id;
    @Id
    private String name;
    private String description;
    private BigDecimal price;
    private Long creationTime;
    private Long lastUpdateTime;
    @ManyToOne
    private Category category;
    private String version;

}
