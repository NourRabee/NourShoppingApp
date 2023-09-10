////////////////////////////////////////////////
//          author: Nour
//          filename: OrderLineItemsResponse.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ps.exalt.shopping.app.common.dto.BaseResponse;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemsResponse extends BaseResponse {
    private String id; //auto generated UUID
    private String skuCode;
    private Integer quantity;
}
