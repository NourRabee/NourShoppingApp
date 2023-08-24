////////////////////////////////////////////////
//          author: Nour
//          filename: CategoryServiceImpl.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ps.exalt.shopping.app.common.service.impl.BaseServiceImpl;
import ps.exalt.shopping.app.dto.CategoryRequest;
import ps.exalt.shopping.app.dto.CategoryResponse;
import ps.exalt.shopping.app.model.Category;
import ps.exalt.shopping.app.repository.CategoryRepository;
import ps.exalt.shopping.app.service.CategoryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<CategoryRequest,
        Category,
        CategoryResponse, String> implements CategoryService {


    private final CategoryRepository categoryRepository;


    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;

    }

    public Category requestToModel(CategoryRequest request) {

        Category category = new Category();
        category.setId(request.getId());
        category.setDescription(request.getDescription());
        category.setVersion("V1.0");
        category.setCreationTime(System.currentTimeMillis());
        category.setLastUpdateTime(System.currentTimeMillis());

        return category;
    }

    public CategoryResponse modelToResponse(Category category) {

        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setDescription(category.getDescription());
        response.setCreationTime(category.getCreationTime());
        response.setLastUpdateTime(category.getLastUpdateTime());
        return response;
    }

    @Override
    public JpaRepository<Category, String> getRepository() {
        return categoryRepository;
    }
    public boolean idExists(String id) {

        return categoryRepository.existsById(id);
    }

    public Category getCategory(String categoryId) {

        return categoryRepository.findById(categoryId).get();
    }
}
