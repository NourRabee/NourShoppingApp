////////////////////////////////////////////////
//          author: Nour
//          filename: CategoryRequest.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.dto;

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

public class CategoryRequest extends BaseRequest {

    private String id;
    private String description;

}
