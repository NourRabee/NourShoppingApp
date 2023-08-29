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

@RestController
@RequestMapping(path = "api/v1.0/inventory")
@Validated
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    @GetMapping
    public boolean isInStock(@RequestParam(name = "id") String id,
                             @RequestParam(name = "quantity") Integer quantity) {

        return inventoryService.existByIdAndQuantity(id, quantity);

    }
    @PostMapping
    public InventoryResponse addToStock(@RequestBody InventoryRequest inventoryRequest) {

        return inventoryService.create(inventoryRequest);

    }

}