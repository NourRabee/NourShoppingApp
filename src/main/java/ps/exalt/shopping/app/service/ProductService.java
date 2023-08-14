////////////////////////////////////////////////
//          author: Nour
//          filename: ProductService.java
//          2023
////////////////////////////////////////////////

package ps.exalt.shopping.app.service;

import ps.exalt.shopping.app.model.Category;
import ps.exalt.shopping.app.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductService {

    List<Product> products = Stream.of(
            new Product("123", "Nour", "Nour's product", new BigDecimal("100.00"), 1692011957L, 1692011996L, Category.BABY_AND_KIDS, "v1"),
            new Product("124", "Rajaie", "Rajaie's product", new BigDecimal("150.00"), 1692011983L, 1692012101L, Category.ELECTRONICS, "v2"),
            new Product("125", "Hazem", "Hazem's product", new BigDecimal("200.00"), 1692011996L, 1692012110L, Category.FASHION, "v1")
    ).collect(Collectors.toList());


    public Product createProduct(String id, String name, String description, BigDecimal price, Long creationTime, Long lastUpdateTime, Category category, String version) {

        Product newProduct = new Product(id, name, description, price, creationTime, lastUpdateTime, category, version);

        return newProduct;
    }

    public void readAllProducts() {

        products.stream().forEach(product -> {
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Creation Time: " + product.getCreationTime());
            System.out.println("Last Update Time: " + product.getLastUpdateTime());
            System.out.println("Category: " + product.getCategory());
            System.out.println("Version: " + product.getVersion());
            System.out.println("--------------");
        });
    }
}

