package dd.projects.ddshop.mapper;

import dd.projects.ddshop.dto.CartDTORequest;
import dd.projects.ddshop.dto.CartEntryDTORequest;
import dd.projects.ddshop.dto.CartEntryDTOResponse;
import dd.projects.ddshop.entity.CartEntry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartEntryMapper {
    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "cartId", target = "cart.id")
    CartEntry dtoRequestToEntity(CartEntryDTORequest cartEntryDTORequest);

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "cart.id", target = "cartId")
    @Mapping(source="product.name",target = "productName")
    CartEntryDTOResponse entityToDto(CartEntry entry);

    List<CartEntryDTOResponse> entityListToDtoList(List<CartEntry> cartEntries);
}
