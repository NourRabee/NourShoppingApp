////////////////////////////////////////////////
//          author: Nour
//          filename: InventoryRequest.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.dto;

import lombok.*;
import ps.exalt.shopping.app.common.dto.BaseRequest;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor

public class InventoryRequest extends BaseRequest<String>{

    private String skuCode;
    private Integer quantity;

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String s) {
    }
}
