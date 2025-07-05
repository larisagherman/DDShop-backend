package dd.projects.ddshop.mapper;

import dd.projects.ddshop.dto.CategoryDTORequest;
import dd.projects.ddshop.dto.CategoryDTOResponse;
import dd.projects.ddshop.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTOResponse entityToDtoResponse(Category category);
    Category dtoResponseToEntity(CategoryDTOResponse categoryDTOResponse);
    CategoryDTORequest entityToDtoRequest(Category category);
    Category dtoRequestToEntity(CategoryDTORequest categoryDTORequest);
    List<CategoryDTOResponse> entityListToDtoResponseList(List<Category> categories);
}
