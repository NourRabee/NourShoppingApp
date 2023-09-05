////////////////////////////////////////////////
//          author: Nour
//          filename: ProductServiceImpl.java
//          2023
////////////////////////////////////////////////

package ps.exalt.shopping.app.service.impl;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ps.exalt.shopping.app.common.error.exception.OperationFailedException;
import ps.exalt.shopping.app.common.service.impl.MySqlBaseServiceImpl;
import ps.exalt.shopping.app.dto.ProductRequest;
import ps.exalt.shopping.app.dto.ProductResponse;
import ps.exalt.shopping.app.model.Category;
import ps.exalt.shopping.app.model.Product;
import ps.exalt.shopping.app.repository.ProductRepository;
import ps.exalt.shopping.app.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl extends MySqlBaseServiceImpl<ProductRequest,
        Product, ProductResponse, String> implements ProductService {
    @Autowired
    private  ProductRepository productRepository;
    @Autowired
    private  CategoryServiceImpl categoryService;

    public Product requestToModel(ProductRequest productRequest) {
        Category category =
                categoryService.getCategory(productRequest.getCategory());
//        return Product.builder()
//                .id(productRequest.getId())
//                .price(productRequest.getPrice())
//                .description(productRequest.getDescription())
//                .lastUpdateTime(System.currentTimeMillis())
//                .creationTime(System.currentTimeMillis())
//                .category(category)
//                .version("V1.0")
//                .build();
        Product request = new Product();
        request.setId(productRequest.getId());
        request.setDescription(productRequest.getDescription());
        request.setPrice(productRequest.getPrice());
        request.setCreationTime(System.currentTimeMillis());
        request.setLastUpdateTime(System.currentTimeMillis());
        request.setCategory(category);
        request.setVersion("V1.0");
        return request;

    }

    public ProductResponse modelToResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setCategory(categoryService.modelToResponse(product.getCategory()));
        response.setVersion(product.getVersion());
        return response;
    }

    public JpaRepository<Product, String> getJpaRepository() {
        return productRepository;
    }

    @SneakyThrows
    public List<ProductResponse> readByIdAndCategory(String id,
                                                     String categoryName) {
        Category category = null;

        if (categoryName != null) {

            category = categoryService.getCategory(categoryName);
        }

        List<Product> productList;

        if (id != null && category != null) {
            if(idExists(id)) {
                productList = productRepository.findByIdAndCategory(id,
                        category);
            }else{
                throw OperationFailedException.createOperationFailedException(getResourceBundle(), "COMMON_00002", id);
            }
        } else if (id != null) {
            if(idExists(id)) {
                productList = productRepository.findByid(id);
            }
            else{
                throw OperationFailedException.createOperationFailedException(getResourceBundle(), "COMMON_00002", id);
            }
        } else {
            productList = productRepository.findByCategory(category);
        }

        return productList.stream()
                .map(this::modelToResponse)
                .collect(Collectors.toList());
    }

}