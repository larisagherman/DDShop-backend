package dd.projects.ddshop.mapper;

import dd.projects.ddshop.dto.UserDTORequest;
import dd.projects.ddshop.dto.UserDTOResponse;
import dd.projects.ddshop.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//@Mapper(componentModel = "spring", uses = AddressMapper.class)
//public interface UserMapper {
////    List<UserDTOResponse> toUserDTOResponseList(List<User> users);
//    UserDTOResponse toUserDTOResponse(User user);
//}
@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface UserMapper {

    @Mapping(source = "deliveryAddress", target = "defaultDeliveryAddress")
    @Mapping(source = "billingAddress", target = "defaultBillingAddress")
    User dtoRequestToEntity(UserDTORequest userDTORequest);

    @Mapping(source = "defaultDeliveryAddress", target = "deliveryAddress")
    @Mapping(source = "defaultBillingAddress", target = "billingAddress")
    UserDTOResponse entityToDTOResponse(User user);
}
