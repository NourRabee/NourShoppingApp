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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Random;

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

    private List<ProductRequest> productRequest = new ArrayList<>();
    private List<ProductResponse> productResponse = new ArrayList<>();


    public ProductRequest createProduct(String name, String description,
                                        BigDecimal price, Category category) {
        for (Product product : products) {

            if (product.getName().equals(name)) {

                ProductRequest newProduct1 = new ProductRequest(name,
                        description, price,
                        category);

                productRequest.add(newProduct1);

                return newProduct1;

            } else {

                Random random = new Random();
                int id = random.nextInt();
                Product newProduct = new Product(String.valueOf(id), name,
                        description, price,
                        System.currentTimeMillis(), System.currentTimeMillis(),
                        category, "V1.0");

                products.add(newProduct);

                ProductRequest newProduct2 = new ProductRequest(name,
                        description, price,
                        category);

                productRequest.add(newProduct2);
                return newProduct2;
            }
        }
        return null;
    }

    public List<ProductResponse> getProducts() {

        productResponse = products.stream()
                .map(product -> {
                    ProductResponse response = new ProductResponse();
                    response.setName(product.getName());
                    response.setDescription(product.getDescription());
                    response.setPrice(product.getPrice());
                    response.setCategory(product.getCategory());
                    response.setVersion(product.getVersion());
                    return response;
                })
                .collect(Collectors.toList());

        return productResponse;

    }
}

