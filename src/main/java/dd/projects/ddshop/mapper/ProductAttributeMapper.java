package dd.projects.ddshop.mapper;

import dd.projects.ddshop.dto.ProductAttributeDTORequest;
import dd.projects.ddshop.dto.ProductAttributeDTOResponse;
import dd.projects.ddshop.entity.ProductAttribute;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {ProductMapper.class})
public interface ProductAttributeMapper {
    ProductAttribute dtoRequestToEntity(ProductAttributeDTORequest productAttributeDTORequest);
    List<ProductAttributeDTOResponse> entityListToDtoList(List<ProductAttribute> productAttributeList);
    @Mapping(source = "productSet", target = "productsSet")
    ProductAttributeDTOResponse entityToDtoResponse(ProductAttribute productAttribute);

}
