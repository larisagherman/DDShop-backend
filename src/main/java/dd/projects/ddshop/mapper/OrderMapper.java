package dd.projects.ddshop.mapper;

import dd.projects.ddshop.dto.OrderDTORequest;
import dd.projects.ddshop.dto.OrderDTOResponse;
import dd.projects.ddshop.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = AddressMapper.class)
public interface OrderMapper {
    @Mapping(source = "userId",target = "userId.id")
    @Mapping(source = "cartId",target = "cartId.id")
    @Mapping(source = "deliveryAddress.",target = "deliveryAddress")
    @Mapping(source = "invoiceAddress",target = "invoiceAddress")
    Order dtoRequestToEntity(OrderDTORequest orderDTORequest);
    @Mapping(source = "userId.id",target = "userId")
    @Mapping(source = "cartId.id",target = "cartId")
    @Mapping(source = "deliveryAddress",target = "deliveryAddress")
    @Mapping(source = "invoiceAddress",target = "invoiceAddress")
    OrderDTOResponse entityToDtoResponse(Order order);

    List<OrderDTOResponse> entityListToDtoResponseList(List<Order> orders);


}
