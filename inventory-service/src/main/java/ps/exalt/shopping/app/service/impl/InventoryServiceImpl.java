////////////////////////////////////////////////
//          author: Nour
//          filename: InventoryServiceImpl.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.util.UriComponentsBuilder;
import ps.exalt.shopping.app.common.service.impl.MongoBaseServiceImpl;
import ps.exalt.shopping.app.dto.InventoryRequest;
import ps.exalt.shopping.app.dto.InventoryResponse;

import ps.exalt.shopping.app.model.Inventory;
import ps.exalt.shopping.app.repository.InventoryRepository;
import ps.exalt.shopping.app.service.InventoryService;

import static ps.exalt.shopping.app.common.error.exception.OperationFailedException.createOperationFailedException;


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
    @SneakyThrows
    public InventoryResponse create(InventoryRequest inventoryRequest) {

        try {
            WebClient client = WebClient.create();
            UriComponentsBuilder uri = UriComponentsBuilder.newInstance();
            uri.scheme("http").host("localhost").port("8080").path("/api/V1" +
                    ".0/product").queryParam("id",
                    inventoryRequest.getSkuCode()).build();
            JsonNode responseBody =
                    client.get().uri(uri.toUriString()).retrieve().bodyToMono(JsonNode.class).block();
            if (!(responseBody == null)) {

                if (inventoryRepository.existsBySkuCode(inventoryRequest.getSkuCode())) {
                    Inventory inventory =
                            inventoryRepository.readBySkuCode(inventoryRequest.getSkuCode());
                    inventory.setQuantity(inventory.getQuantity() + inventoryRequest.getQuantity());
                    Inventory updatedInventory =
                            getMongoRepository().save(inventory);
                    return modelToResponse(updatedInventory);
                } else {
                    return super.create(inventoryRequest);
                }
            } else {
                throw createOperationFailedException(getResourceBundle(),
                        "COMMON_00002", "skuCode",
                        inventoryRequest.getSkuCode());
            }

        } catch (WebClientResponseException ex) {

            throw createOperationFailedException(getResourceBundle(),
                    "COMMON_00002", "skuCode", inventoryRequest.getSkuCode());

        }

    }

    public boolean existByIdAndQuantity(String id, Integer quantity) {

        if (inventoryRepository.existsById(id) && quantity >= 1) {

            return true;

        }
        return false;
    }

    @SneakyThrows
    @Override
    public void update(InventoryRequest inventoryRequest) {

        if (inventoryRepository.existsBySkuCode(inventoryRequest.getSkuCode())) {
            Inventory inventory =
                    inventoryRepository.readBySkuCode(inventoryRequest.getSkuCode());
            inventory.setQuantity(inventoryRequest.getQuantity());
            getMongoRepository().save(inventory);
        } else {
            throw createOperationFailedException(getResourceBundle(),
                    "COMMON_00002", "skuCode", inventoryRequest.getSkuCode());
        }
    }
}
