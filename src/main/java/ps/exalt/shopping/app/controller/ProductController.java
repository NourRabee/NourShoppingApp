////////////////////////////////////////////////
//          author: Nour
//          filename: ProductController.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ps.exalt.shopping.app.dto.ProductRequest;
import ps.exalt.shopping.app.dto.ProductResponse;
import ps.exalt.shopping.app.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(path = "api/V1.0/product")
@Validated
public class ProductController {

    @Autowired
    public final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //    @GetMapping
//    public List<ProductResponse> getAllProducts(){
//
//        return productService.getProducts();
//    }
    @PostMapping
    public ProductResponse createNewProduct(@RequestBody @Valid ProductRequest productRequest) {

        return productService.createProduct(productRequest);
    }

    @GetMapping
    public List<ProductResponse> getProduct(@RequestParam(name = "id",
            required = false) String id, @RequestParam(name = "category",
            required = false) String category) {
        return productService.getProductByIdAndCategory(id, category);
    }

    @DeleteMapping
    public void deleteProduct(@RequestParam(name = "id", required = true) String id) {
        boolean idExists = productService.idExists(id);
        if (idExists) {
            productService.deleteProductById(id);
        }
    }

    @PutMapping
    public void updateProduct(@RequestBody @Valid ProductRequest productRequest) {
        productService.update(productRequest);
    }
}