////////////////////////////////////////////////
//          author: Nour
//          filename: ProductService.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.service;

import ps.exalt.shopping.app.common.service.BaseService;
import ps.exalt.shopping.app.dto.ProductRequest;
import ps.exalt.shopping.app.dto.ProductResponse;
import ps.exalt.shopping.app.model.Product;

import java.util.List;

public interface ProductService extends BaseService<ProductRequest, Product,
        ProductResponse, String> {

    public List<ProductResponse> readByIdAndCategory(String id,
                                                     String categoryName);

}
