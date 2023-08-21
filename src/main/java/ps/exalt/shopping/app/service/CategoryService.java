////////////////////////////////////////////////
//          author: Nour
//          filename: CategoryService.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ps.exalt.shopping.app.dto.CategoryRequest;
import ps.exalt.shopping.app.dto.CategoryResponse;
import ps.exalt.shopping.app.model.Category;
import ps.exalt.shopping.app.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {


    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponse createCategory(CategoryRequest categoryRequest) {

        Category category = requestToModel(categoryRequest);
        return modelToResponse(categoryRepository.save(category));
    }

    public Category requestToModel(CategoryRequest request) {

        Category category = new Category(request.getId(),
                request.getDescription(), System.currentTimeMillis(),
                System.currentTimeMillis(), "V1.0");

        return category;
    }

    public CategoryResponse modelToResponse(Category category) {

        CategoryResponse response = new CategoryResponse(category.getId(),
                category.getDescription(), category.getCreationTime(),
                category.getLastUpdateTime());
        return response;
    }

    public List<CategoryResponse> getCategoryById(String id) {

        Optional<Category> categoryList;

        categoryList = categoryRepository.findById(id);

        return categoryList.stream()
                .map(category -> modelToResponse(category))
                .collect(Collectors.toList());
    }


    public void deleteProductById(String id) {

        categoryRepository.deleteById(id);
    }

    public void update(CategoryRequest categoryRequest) {


        Optional<Category> categoryOptional =
                categoryRepository.findById(categoryRequest.getId());

        if (categoryOptional.isPresent()) {

            Category category = categoryOptional.get();
            category.setDescription(categoryRequest.getDescription());

            categoryRepository.save(category);

        }
    }

    public boolean idExists(String id) {

        return categoryRepository.existsById(id);
    }

    public List<CategoryResponse> getAll() {

        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(category -> modelToResponse(category))
                .collect(Collectors.toList());
    }
}
