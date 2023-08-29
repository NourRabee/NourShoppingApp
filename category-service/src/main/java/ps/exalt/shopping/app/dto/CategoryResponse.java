////////////////////////////////////////////////
//          author: Nour
//          filename: CategoryResponse.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ps.exalt.shopping.app.common.dto.BaseResponse;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class CategoryResponse extends BaseResponse {

    private String id;
    private String description;
    private Long creationTime;
    private Long lastUpdateTime;
}
