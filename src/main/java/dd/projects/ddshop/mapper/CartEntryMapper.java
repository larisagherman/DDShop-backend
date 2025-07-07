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
    @Mapping(source = "productId", target = "productId.id")
    @Mapping(source = "cartId", target = "cartId.id")
    CartEntry dtoRequestToEntity(CartEntryDTORequest cartEntryDTORequest);

    @Mapping(source = "productId.id", target = "productId")
    @Mapping(source = "cartId.id", target = "cartId")
    CartEntryDTOResponse entityToDto(CartEntry entry);

    List<CartEntryDTOResponse> entityListToDtoList(List<CartEntry> cartEntries);
}
