package dd.projects.ddshop.controller;

import dd.projects.ddshop.dto.CategoryDTORequest;
import dd.projects.ddshop.dto.CategoryDTOResponse;
import dd.projects.ddshop.entity.Category;
import dd.projects.ddshop.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping
    public CategoryDTOResponse createCategory(@RequestBody CategoryDTORequest categoryDTORequest) {
        return categoryService.createCategory(categoryDTORequest);
    }
    @GetMapping
    public List<CategoryDTOResponse> getAllCategories(){
        return categoryService.getAllCategories();
    }
    @PostMapping("{id}")
    public CategoryDTOResponse updateCategory(@PathVariable("id") Integer id, @RequestBody CategoryDTORequest categoryDTORequest) {
        return categoryService.updateCategory(id, categoryDTORequest);
    }
    @DeleteMapping("{id}")
    public void deleteCategory(@PathVariable("id") Integer id) {
        categoryService.deleteCategoryById(id);
    }

}