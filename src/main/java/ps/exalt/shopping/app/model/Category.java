////////////////////////////////////////////////
//          author: Nour
//          filename: Category.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Category {

    private String id;
    private String description;
    private Long creationTime;
    private Long lastUpdateTime;
    private String version;
}