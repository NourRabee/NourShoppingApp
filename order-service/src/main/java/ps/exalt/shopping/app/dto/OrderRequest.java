////////////////////////////////////////////////
//          author: Nour
//          filename: OrderRequest.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.dto;

import lombok.*;
import ps.exalt.shopping.app.common.dto.BaseRequest;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor

public class OrderRequest extends BaseRequest<String>{

    private List<OrderLineItemsRequest> orderLineItemsRequestList;

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String s) {
    }
}
