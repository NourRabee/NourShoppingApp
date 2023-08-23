////////////////////////////////////////////////
//          author: Nour
//          filename: ProductService.java
//          2023
////////////////////////////////////////////////

package ps.exalt.shopping.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ps.exalt.shopping.app.common.service.BaseService;
import ps.exalt.shopping.app.dto.ProductRequest;
import ps.exalt.shopping.app.dto.ProductResponse;
import ps.exalt.shopping.app.model.Category;
import ps.exalt.shopping.app.model.Product;
import ps.exalt.shopping.app.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService  extends BaseService{

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          CategoryService categoryService) {

        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = requestToModel(productRequest);
        return modelToResponse(productRepository.save(product));
    }

    private Product requestToModel(ProductRequest productRequest) {
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

//    public List<ProductResponse> getProducts() {
//
//        return productRepository.findAll().stream()
//                .map(product -> modelToResponse(product))
//                .collect(Collectors.toList());
//    }

    private ProductResponse modelToResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setCategory(categoryService.modelToResponse(product.getCategory()));
        response.setVersion(product.getVersion());
        return response;
    }

    public List<ProductResponse> getProductByIdAndCategory(String id,
                                                             String
                                                                     categoryName) {
        Category category = null;

        if (categoryName != null) {

            category = categoryService.getCategory(categoryName);
        }

        List<Product> productList;

        if (id != null && category != null) {
            productList = productRepository.findByIdAndCategory(id,
                    category);
        } else if (id != null) {
            productList = productRepository.findByid(id);
        } else if (category != null) {
            productList = productRepository.findByCategory(category);
        } else {
            productList = productRepository.findAll();
        }

        return productList.stream()
                .map(product -> modelToResponse(product))
                .collect(Collectors.toList());
    }

    public boolean idExists(String id) {

        return productRepository.existsById(id);

    }

    public void deleteProductById(String id) {
        productRepository.deleteById(id);
    }

    public void update(ProductRequest productRequest) {
        Optional<Product> productOptional =
                productRepository.findById(productRequest.getId());

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setDescription(productRequest.getDescription());
            product.setPrice(productRequest.getPrice());

            Category category =
                    categoryService.getCategory(productRequest
                            .getCategory());
            product.setCategory(category);

            productRepository.save(product);
        }
    }

}