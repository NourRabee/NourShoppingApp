////////////////////////////////////////////////
//          author: Nour
//          filename: CategoryRequest.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ps.exalt.shopping.app.common.dto.BaseRequest;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor

public class CategoryRequest extends BaseRequest<String> {
    @NotEmpty(message = "id must not be empty")
    private String id;
    private String description;
}
