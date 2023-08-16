////////////////////////////////////////////////
//          author: Nour
//          filename: ProductController.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ps.exalt.shopping.app.dto.ProductRequest;
import ps.exalt.shopping.app.dto.ProductResponse;
import ps.exalt.shopping.app.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(path = "api/V1.0/product")
public class ProductController {

    @Autowired
    public final ProductService productService = new ProductService();


    @GetMapping
    public List<ProductResponse> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public ProductRequest createNewProduct(@RequestBody ProductRequest productRequest) {

        return productService.createProduct(productRequest.getName(),
                productRequest.getDescription(), productRequest.getPrice(),
                productRequest.getCategory());
    }

}
