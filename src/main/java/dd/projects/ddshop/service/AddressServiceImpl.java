package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.AddressDTO;
import dd.projects.ddshop.dto.UserDTO;
import dd.projects.ddshop.entity.Address;
import dd.projects.ddshop.entity.User;
import dd.projects.ddshop.repository.AddressRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public List<AddressDTO> getAddresses() {
        List<Address> addresses= addressRepository.findAll();
        return addresses.stream().map(it->fromAddressToAddressDTO(it)).collect(Collectors.toList());
    }
    public AddressDTO fromAddressToAddressDTO(Address address){
        return new AddressDTO(address.getId(),address.getStreetLine(),address.getPostalCode(),address.getCity(),address.getCounty(),address.getCountry());
    }




}
