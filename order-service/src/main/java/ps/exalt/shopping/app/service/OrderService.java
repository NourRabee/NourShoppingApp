////////////////////////////////////////////////
//          author: Nour
//          filename: InventoryService.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.service;

import ps.exalt.shopping.app.common.service.BaseService;
import ps.exalt.shopping.app.dto.OrderRequest;
import ps.exalt.shopping.app.dto.OrderResponse;
import ps.exalt.shopping.app.model.Order;


public interface OrderService extends BaseService<OrderRequest,
        Order, OrderResponse, String> {

    public boolean existByIdAndQuantity(String id, Integer quantity);

}
