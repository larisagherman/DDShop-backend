package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.AddressDTO;
import dd.projects.ddshop.entity.Address;

import java.util.List;

public interface AddressService {
    public List<AddressDTO> getAddresses();
//    public AddressDTO getAddressById(Integer id);
//    public Address createAddress(Address address);
//    public Address updateAddress(Address address);
//    public void deleteAddress(Integer id);
}
