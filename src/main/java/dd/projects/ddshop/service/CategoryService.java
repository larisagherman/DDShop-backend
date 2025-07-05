package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.CategoryDTORequest;
import dd.projects.ddshop.dto.CategoryDTOResponse;
import dd.projects.ddshop.dto.ProductDTOResponse;
import dd.projects.ddshop.entity.Category;
import dd.projects.ddshop.mapper.CategoryMapper;
import dd.projects.ddshop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryDTOResponse createCategory(CategoryDTORequest categoryDTORequest) {
        Category newCategory = categoryMapper.dtoRequestToEntity(categoryDTORequest);
        Category savedCategory = categoryRepository.save(newCategory);
        return categoryMapper.entityToDtoResponse(savedCategory);
    }

    public List<CategoryDTOResponse> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryMapper.entityListToDtoResponseList(categoryList);
    }
    public CategoryDTOResponse getCategoryById(Integer id) {
        Category category = categoryRepository.findById(id).orElse(null);
        return categoryMapper.entityToDtoResponse(category);
    }
    public CategoryDTOResponse updateCategory(Integer id,CategoryDTORequest categoryDTORequest) {
        Category existingCategory = categoryRepository.findById(id).orElse(null);
        existingCategory.setName(categoryDTORequest.getName());
        existingCategory.setDescription(categoryDTORequest.getDescription());
        Category updatedCategory = categoryRepository.save(existingCategory);
        return categoryMapper.entityToDtoResponse(updatedCategory);
    }
    public void deleteCategoryById(Integer id) {
        categoryRepository.deleteById(id);
    }

}

