package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.AddressDTORequest;
import dd.projects.ddshop.dto.AddressDTOResponse;
import dd.projects.ddshop.entity.Address;

import java.util.List;

public interface AddressService {
    public AddressDTOResponse createAddress(AddressDTORequest addressDTORequest);
    public List<AddressDTOResponse> getAddresses();
    public AddressDTOResponse getAddressById(Integer addressId);
    public AddressDTOResponse updateAddress(Integer id,AddressDTORequest address);
    public AddressDTOResponse deleteAddress(Integer id);
}
