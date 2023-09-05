////////////////////////////////////////////////
//          author: Nour
//          filename: InventoryResponse.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.dto;

import lombok.*;
import ps.exalt.shopping.app.common.dto.BaseResponse;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class InventoryResponse extends BaseResponse{

    private String id;
    private String skuCode;
    private Integer quantity;
}
