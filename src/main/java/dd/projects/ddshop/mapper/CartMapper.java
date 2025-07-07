package dd.projects.ddshop.mapper;

import dd.projects.ddshop.dto.CartDTORequest;
import dd.projects.ddshop.dto.CartDTOResponse;
import dd.projects.ddshop.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {CartEntryMapper.class})
public interface CartMapper {
 @Mapping(source = "userId", target="userId.id")
 Cart dtoRequestToEntity(CartDTORequest cartDTORequest);
 @Mapping(source = "userId.id",target = "userId")
 @Mapping(source = "cartEntries",target = "cartEntries")
 CartDTOResponse entityToDto(Cart cart);
 
 List<CartDTOResponse> entityListToDtoList(List<Cart> cartList);

}
