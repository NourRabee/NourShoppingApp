////////////////////////////////////////////////
//          author: Nour
//          filename: CategoryController.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import ps.exalt.shopping.app.dto.CategoryRequest;
import ps.exalt.shopping.app.dto.CategoryResponse;
import ps.exalt.shopping.app.service.CategoryService;
import ps.exalt.shopping.app.service.impl.CategoryServiceImpl;


import java.util.List;

@RestController
@RequestMapping(path = "api/V1.0/category")
@Validated
public class CategoryController {

    @Autowired
    public final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

//    @GetMapping
//    public List<CategoryResponse> getCategory(){
//
//        return categoryService.getAll();
//
//    }

    @PostMapping
    public CategoryResponse createNewCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        return categoryService.create(categoryRequest);
    }

    @GetMapping
    public CategoryResponse getCategory(@RequestParam(name = "id") String id) {
            return categoryService.read(id);
    }
    @GetMapping
    public List<CategoryResponse> getCategory() {
            return categoryService.read();
    }

    @DeleteMapping
    public void delete(@RequestParam(name = "id", required = true) String id) {
        boolean nameExists = categoryService.idExists(id);
        if (nameExists) {
            categoryService.delete(id);
        }
    }

    @PutMapping
    public void updateCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        categoryService.update(categoryRequest);
    }

}
