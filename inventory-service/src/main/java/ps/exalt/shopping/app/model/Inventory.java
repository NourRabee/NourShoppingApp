////////////////////////////////////////////////
//          author: Nour
//          filename: Inventory.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ps.exalt.shopping.app.common.model.BaseModel;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table
public class Inventory extends BaseModel<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    private String skuCode;
    private Integer quantity;

}