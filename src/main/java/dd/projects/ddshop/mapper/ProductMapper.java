package dd.projects.ddshop.mapper;

import dd.projects.ddshop.dto.ProductDTORequest;
import dd.projects.ddshop.dto.ProductDTOResponse;
import dd.projects.ddshop.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "categoryId.name", target = "categoryName")
    ProductDTOResponse entityToDTOResponse(Product product);

    @Mapping(target = "categoryId", ignore = true)
    Product dtoRequestToEntity(ProductDTORequest productDTORequest);

    List<ProductDTOResponse> entityListToDTOList(List<Product> products);
}
