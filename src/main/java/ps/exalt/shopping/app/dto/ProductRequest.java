////////////////////////////////////////////////
//          author: Nour
//          filename: ProductRequest.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ps.exalt.shopping.app.model.Category;

import java.math.BigDecimal;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor

public class ProductRequest {

    private String name;
    private String description;
    private BigDecimal price;
    private Category category;

}
