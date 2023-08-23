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
import ps.exalt.shopping.app.common.dto.BaseResponse;

import java.math.BigDecimal;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor

public class ProductResponse extends BaseResponse {


    private String id;
    private String description;
    private BigDecimal price;
    private CategoryResponse category;
    private String version;


}
