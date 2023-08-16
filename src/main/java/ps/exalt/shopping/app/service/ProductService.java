////////////////////////////////////////////////
//          author: Nour
//          filename: ProductService.java
//          2023
////////////////////////////////////////////////

package ps.exalt.shopping.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ps.exalt.shopping.app.dto.ProductRequest;
import ps.exalt.shopping.app.dto.ProductResponse;
import ps.exalt.shopping.app.model.Product;
import ps.exalt.shopping.app.repository.ProductRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {


    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = requestToModel(productRequest);
        return modelToResponse(productRepository.save(product));
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

        return productRepository.findAll().stream()
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

