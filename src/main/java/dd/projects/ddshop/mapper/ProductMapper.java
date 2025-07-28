package dd.projects.ddshop.mapper;

import dd.projects.ddshop.dto.ProductDTORequest;
import dd.projects.ddshop.dto.ProductDTOResponse;
import dd.projects.ddshop.dto.ProductImageDTOResponse;
import dd.projects.ddshop.entity.Product;
import dd.projects.ddshop.entity.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "categoryId.name", target = "categoryName")
    @Mapping(source = "productAttributeSet", target = "productAttributes")
    @Mapping(source = "productImageUrls", target = "imageUrls")
    ProductDTOResponse entityToDTOResponse(Product product);

    @Mapping(target = "categoryId", ignore = true)
    @Mapping(source = "imageUrls", target = "productImageUrls")
    Product dtoRequestToEntity(ProductDTORequest productDTORequest);

    List<ProductDTOResponse> entityListToDTOList(List<Product> products);

    @Mapping(source = "product.id", target = "productId")
    ProductImageDTOResponse mapProductImageToDTO(ProductImage image);

    List<ProductImageDTOResponse> mapProductImageListToDTO(List<ProductImage> images);


}
