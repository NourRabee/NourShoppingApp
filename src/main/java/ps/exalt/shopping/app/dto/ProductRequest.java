////////////////////////////////////////////////
//          author: Nour
//          filename: ProductRequest.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import ps.exalt.shopping.app.customAnnotation.NameExists;
import ps.exalt.shopping.app.customAnnotation.ValidEnum;
import ps.exalt.shopping.app.model.Category;

import java.math.BigDecimal;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor

public class ProductRequest {

    @NotEmpty(message = "Name must not be empty")
    @NameExists(message = "Value already exists")
    private String name;
    private String description;
    @DecimalMin(value = "0", inclusive = true, message = "The price must not " +
            "be less than {value}")
    @DecimalMax(value = "100000", inclusive = true, message = "The price must" +
            " not be greater than {value}")
    private BigDecimal price;
    @ValidEnum(enumClass = Category.class, message = "Please provide a valid " +
            "category")
    private String category;

}
