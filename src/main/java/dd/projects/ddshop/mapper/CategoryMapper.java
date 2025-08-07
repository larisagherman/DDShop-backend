package dd.projects.ddshop.mapper;

import dd.projects.ddshop.dto.CategoryDTORequest;
import dd.projects.ddshop.dto.CategoryDTOResponse;
import dd.projects.ddshop.dto.CategoryDTOResponse2;
import dd.projects.ddshop.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = ProductMapper.class)
public interface CategoryMapper {
    @Mapping(source = "products", target = "products")
    CategoryDTOResponse entityToDtoResponse(Category category);
    @Mapping(source = "products",target = "products")
    @Mapping(source = "products.categoryId",target = "products.categoryName")
    List<CategoryDTOResponse> entityListToDtoResponseList(List<Category> categories);
    Category dtoRequestToEntity(CategoryDTORequest categoryDTORequest);

    Category dtoResponseToEntity(CategoryDTOResponse categoryDTOResponse);
    CategoryDTORequest entityToDtoRequest(Category category);

    CategoryDTOResponse2 entityToDtoResponse2(Category category);
    List<CategoryDTOResponse2> entityListToDtoResponse2List(List<Category> categories);


    List<CategoryDTORequest> entityListToDtoRequestList(List<Category> category);
}
