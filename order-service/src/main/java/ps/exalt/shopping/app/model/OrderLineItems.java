////////////////////////////////////////////////
//          author: Nour
//          filename: OrderLineItems.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ps.exalt.shopping.app.common.model.BaseModel;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderLineItems extends BaseModel<String> {
    private String id; //auto generated UUID
    private String skuCode;
    private Integer quantity;
    //make sure that the quantity of skuCode exists in the inventory service
}
