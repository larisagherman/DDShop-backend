package dd.projects.ddshop.mapper;

import dd.projects.ddshop.dto.AddressDTORequest;
import dd.projects.ddshop.dto.AddressDTOResponse;
import dd.projects.ddshop.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDTOResponse fromEntityToDTOResponse(Address address);
    Address fromDTOResponseToEntity(AddressDTOResponse addressDTOResponse);
    Address fromDTORequestToEntity(AddressDTORequest addressDTORequest);

}
