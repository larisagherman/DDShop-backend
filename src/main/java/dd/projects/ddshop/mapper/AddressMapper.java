package dd.projects.ddshop.mapper;

import dd.projects.ddshop.dto.AddressDTORequest;
import dd.projects.ddshop.dto.AddressDTOResponse;
import dd.projects.ddshop.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDTOResponse entityToDTOResponse(Address address);
    Address dtoRequestToEntity(AddressDTORequest addressDTORequest);

}
