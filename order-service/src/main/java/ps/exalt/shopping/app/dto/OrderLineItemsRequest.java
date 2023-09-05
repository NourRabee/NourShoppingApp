////////////////////////////////////////////////
//          author: Nour
//          filename: OrderLineItemsRequest.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ps.exalt.shopping.app.common.dto.BaseRequest;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemsRequest extends BaseRequest<String> {

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
