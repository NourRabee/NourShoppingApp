////////////////////////////////////////////////
//          author: Nour
//          filename: ProductController.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ps.exalt.shopping.app.model.Product;
import ps.exalt.shopping.app.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(path = "api/V1.0/product")
public class ProductController {
    
    @Autowired
    public final ProductService productService = new ProductService();
    

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public Product createNewProduct(@RequestBody Product product) {

        return productService.createProduct(product.getId(), product.getName(),
                product.getDescription(), product.getPrice(),
                product.getCategory(), product.getVersion());
    }

}
