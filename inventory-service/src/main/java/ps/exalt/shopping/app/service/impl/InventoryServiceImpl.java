////////////////////////////////////////////////
//          author: Nour
//          filename: InventoryServiceImpl.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import ps.exalt.shopping.app.common.service.impl.MongoBaseServiceImpl;
import ps.exalt.shopping.app.dto.InventoryRequest;
import ps.exalt.shopping.app.dto.InventoryResponse;
import ps.exalt.shopping.app.model.Inventory;
import ps.exalt.shopping.app.repository.InventoryRepository;
import ps.exalt.shopping.app.service.InventoryService;

@Service
public class InventoryServiceImpl extends MongoBaseServiceImpl<InventoryRequest,
        Inventory, InventoryResponse, String> implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory requestToModel(InventoryRequest request) {

        Inventory inventory = new Inventory();
        inventory.setQuantity(request.getQuantity());
        inventory.setSkuCode(request.getSkuCode());
        return inventory;
    }

    public InventoryResponse modelToResponse(Inventory inventory) {

        InventoryResponse response = new InventoryResponse();
        response.setId(inventory.getId());
        response.setQuantity(inventory.getQuantity());
        response.setSkuCode(inventory.getSkuCode());
        return response;
    }

    @Override
    public MongoRepository<Inventory, String> getMongoRepository() {
        return inventoryRepository;
    }

    @Override
    public InventoryResponse create(InventoryRequest inventoryRequest) {

        //http req product get id
        return super.create(inventoryRequest);
    }

    public boolean existByIdAndQuantity(String id, Integer quantity){

        if(inventoryRepository.existsById(id) && quantity >= 1){

            return true;

        }
        return false;
    }


}
