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

import java.util.List;


public interface InventoryService extends BaseService<InventoryRequest,
        Inventory, InventoryResponse, String> {

    public boolean existByIdAndQuantity(String id, Integer quantity);

    public List<InventoryResponse> readBySkuCode(List<String> skuCodeList);
    public void update(String skuCode, Integer quantity);
}
