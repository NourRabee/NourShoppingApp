////////////////////////////////////////////////
//          author: Nour
//          filename: CategoryService.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.service;

import ps.exalt.shopping.app.common.service.BaseService;
import ps.exalt.shopping.app.dto.CategoryRequest;
import ps.exalt.shopping.app.dto.CategoryResponse;
import ps.exalt.shopping.app.model.Category;


public interface CategoryService extends BaseService<CategoryRequest,
        Category, CategoryResponse, String> {

}
