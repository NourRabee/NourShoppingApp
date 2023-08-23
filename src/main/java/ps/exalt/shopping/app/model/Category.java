////////////////////////////////////////////////
//          author: Nour
//          filename: Category.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ps.exalt.shopping.app.common.model.BaseModel;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table
public class Category extends BaseModel {
    @Id
    private String id;
    private String description;

}