////////////////////////////////////////////////
//          author: Nour
//          filename: Category.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table
public class Category {
    @Id
    private String id;
    private String description;
    private Long creationTime;
    private Long lastUpdateTime;
    private String version;

}