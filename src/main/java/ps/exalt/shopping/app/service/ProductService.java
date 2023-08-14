////////////////////////////////////////////////
//          author: Nour
//          filename: ProductService.java
//          2023
////////////////////////////////////////////////

package ps.exalt.shopping.app.service;

import org.springframework.stereotype.Service;
import ps.exalt.shopping.app.model.Category;
import ps.exalt.shopping.app.model.Product;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
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


    public Product createProduct(String id, String name, String description,
                                 BigDecimal price, Category category,
                                 String version) {
        Product newProduct = new Product(id, name, description, price,
                System.currentTimeMillis(), System.currentTimeMillis(),
                category, version);
        if (products.add(newProduct)) {
            return newProduct;
        }
        return null;
    }

    public List<Product> getProducts() {
        return products;
    }
}

