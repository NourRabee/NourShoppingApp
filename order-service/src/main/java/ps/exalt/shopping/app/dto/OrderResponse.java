////////////////////////////////////////////////
//          author: Nour
//          filename: OrderResponse.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.dto;

import lombok.*;
import ps.exalt.shopping.app.common.dto.BaseResponse;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class OrderResponse extends BaseResponse{

    private String id;
    private List<OrderLineItemsResponse> orderLineItemsResponseList;
}
