////////////////////////////////////////////////
//          author: Nour
//          filename: InventoryController.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ps.exalt.shopping.app.dto.InventoryRequest;

import ps.exalt.shopping.app.dto.InventoryResponse;
import ps.exalt.shopping.app.service.InventoryService;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1.0/inventory")
@Validated
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
//    @GetMapping
//    public boolean isInStock(@RequestParam(name = "id") String id,
//                             @RequestParam(name = "quantity") Integer
//                             quantity) {
//
//        return inventoryService.existByIdAndQuantity(id, quantity);
//
//    }

//    @GetMapping
//    public List<InventoryResponse> getAll() {
//        return inventoryService.read();
//    }
//    @GetMapping
//    public List<InventoryResponse> getCategory(@RequestParam(name = "id",
//            required = false) String id) {
//        if (id == null) {
//            return inventoryService.read();
//        } else {
//            return Collections.singletonList(inventoryService.read(id));
//        }
//    }

    @GetMapping
    public List<InventoryResponse> getBySkuCode(@RequestParam(name = "skuCode"
    ) List<String> skuCodeList) {

        return inventoryService.readBySkuCode(skuCodeList);

    }

    @PostMapping
    public InventoryResponse addToStock(@RequestBody InventoryRequest inventoryRequest) {
        return inventoryService.create(inventoryRequest);
    }

    @PutMapping
    public void updateInventory(@RequestParam(name = "skuCode") String skuCode,
                                @RequestParam(name = "quantity") Integer quantity) {
        inventoryService.update(skuCode, quantity);

    }
    @DeleteMapping
    public void delete(@RequestParam(name = "id", required = true) String id) {
        inventoryService.delete(id);
    }

}