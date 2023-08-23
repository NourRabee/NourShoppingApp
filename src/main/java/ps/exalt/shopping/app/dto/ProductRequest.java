////////////////////////////////////////////////
//          author: Nour
//          filename: ProductRequest.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ps.exalt.shopping.app.common.dto.BaseRequest;
import ps.exalt.shopping.app.customAnnotation.ValidEnum;
import ps.exalt.shopping.app.model.CategoryEnum;

import java.math.BigDecimal;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor

public class ProductRequest extends BaseRequest<String> {

    @NotEmpty(message = "id must not be empty")
    private String id;
    private String description;
    @DecimalMin(value = "0", inclusive = true, message = "The price must not " +
            "be less than {value}")
    @DecimalMax(value = "100000", inclusive = true, message = "The price must" +
            " not be greater than {value}")
    private BigDecimal price;
    private String category;

}