////////////////////////////////////////////////
//          author: Nour
//          filename: ProductController.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.controller;

import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ps.exalt.shopping.app.dto.ProductRequest;
import ps.exalt.shopping.app.dto.ProductResponse;
import ps.exalt.shopping.app.service.ProductService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "api/V1.0/product")
@Validated
public class ProductController {

    @Autowired
    public final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductResponse createNewProduct(@RequestBody @Valid ProductRequest productRequest) {

        return productService.create(productRequest);
    }

    @SneakyThrows
    @GetMapping
    public List<ProductResponse> getProduct(@RequestParam(name = "id",
            required = false) String id, @RequestParam(name = "category",
            required = false) String category) {
        if (id == null && category == null) {
            return productService.read();
        } else {
            List<ProductResponse> productList =
                    productService.readByIdAndCategory(id, category);
            return productList;
        }
    }

    @DeleteMapping
    public void deleteProduct(@RequestParam(name = "id", required = true) String id) {
        productService.delete(id);

    }

    @PutMapping
    public void updateProduct(@RequestBody @Valid ProductRequest productRequest) {
        productService.update(productRequest);
    }

}