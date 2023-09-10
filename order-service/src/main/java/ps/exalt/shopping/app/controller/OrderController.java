////////////////////////////////////////////////
//          author: Nour
//          filename: OrderController.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ps.exalt.shopping.app.dto.OrderRequest;
import ps.exalt.shopping.app.dto.OrderResponse;
import ps.exalt.shopping.app.service.OrderService;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1.0/order")
@Validated
public class OrderController {

    @Autowired
    public OrderService orderService;

//    @GetMapping
//    public boolean isInStock(@RequestParam(name = "id") String id,
//                             @RequestParam(name = "quantity") Integer
//                             quantity) {
//
//        return inventoryService.existByIdAndQuantity(id, quantity);
//
//    }
//    @GetMapping
//    public List<OrderResponse> getAll() {
//        return orderService.read();
//    }
    @GetMapping
    public List<OrderResponse> getCategory(@RequestParam(name = "id",
            required = false) String id) {
        if (id == null) {
            return orderService.read();
        } else {
            return Collections.singletonList(orderService.read(id));
        }
    }
    @PostMapping
    public OrderResponse placeOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.create(orderRequest);
    }


    @DeleteMapping
    public void delete(@RequestParam(name = "id") String id) {
        orderService.delete(id);
    }

}