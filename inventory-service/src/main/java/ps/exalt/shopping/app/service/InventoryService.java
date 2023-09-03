////////////////////////////////////////////////
//          author: Nour
//          filename: InventoryService.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.service;

import ps.exalt.shopping.app.common.service.BaseService;
import ps.exalt.shopping.app.dto.InventoryRequest;
import ps.exalt.shopping.app.dto.InventoryResponse;
import ps.exalt.shopping.app.model.Inventory;


public interface InventoryService extends BaseService<InventoryRequest,
        Inventory, InventoryResponse, String> {

    public boolean existByIdAndQuantity(String id, Integer quantity);

}
