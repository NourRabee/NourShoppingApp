////////////////////////////////////////////////
//          author: Nour
//          filename: ProductResponse.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;
import ps.exalt.shopping.app.model.Category;

import java.math.BigDecimal;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
public class ProductResponse {


    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private String version;


}
