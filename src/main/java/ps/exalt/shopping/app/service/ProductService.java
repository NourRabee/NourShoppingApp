////////////////////////////////////////////////
//          author: Nour
//          filename: ProductService.java
//          2023
////////////////////////////////////////////////

package ps.exalt.shopping.app.service;

import org.springframework.stereotype.Service;
import ps.exalt.shopping.app.dto.ProductRequest;
import ps.exalt.shopping.app.dto.ProductResponse;
import ps.exalt.shopping.app.model.Category;
import ps.exalt.shopping.app.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService {

    private List<Product> products = Stream.of(
            new Product("123", "Nour", "Nour's product", new BigDecimal("100" +
                    ".00"), System.currentTimeMillis(),
                    System.currentTimeMillis(), Category.BABY_AND_KIDS, "v1"),
            new Product("124", "Rajaie", "Rajaie's product", new BigDecimal(
                    "150.00"), System.currentTimeMillis(),
                    System.currentTimeMillis(), Category.ELECTRONICS, "v2"),
            new Product("125", "Hazem", "Hazem's product", new BigDecimal(
                    "200.00"), System.currentTimeMillis(),
                    System.currentTimeMillis(), Category.FASHION, "v1")
    ).collect(Collectors.toList());

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = requestToModel(productRequest);
        products.add(product);
        return modelToResponse(product);
    }

    private Product requestToModel(ProductRequest productRequest) {

        Product request = new Product();
        request.setName(productRequest.getName());
        request.setId(String.valueOf(UUID.randomUUID()));
        request.setDescription(productRequest.getDescription());
        request.setPrice(productRequest.getPrice());
        request.setCategory(productRequest.getCategory());
        request.setCreationTime(System.currentTimeMillis());
        request.setLastUpdateTime(System.currentTimeMillis());
        request.setVersion("V1.0");
        return request;

    }

    public List<ProductResponse> getProducts() {

        return products.stream()
                .map(product -> modelToResponse(product))
                .collect(Collectors.toList());
    }

    private ProductResponse modelToResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setCategory(product.getCategory());
        response.setVersion(product.getVersion());
        return response;
    }
}

