package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.AddressDTORequest;
import dd.projects.ddshop.dto.AddressDTOResponse;
import dd.projects.ddshop.entity.Address;
import dd.projects.ddshop.mapper.AddressMapper;
import dd.projects.ddshop.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    public AddressDTOResponse createAddress(AddressDTORequest address) {
        Address newAddress=addressMapper.fromDTORequestToEntity(address);
        Address savedAddress=addressRepository.save(newAddress);
        return addressMapper.fromEntityToDTOResponse(savedAddress);
    }
    public List<AddressDTOResponse> getAddresses() {
        List<Address> addresses= addressRepository.findAll();
        return addresses.stream().map(addressMapper::fromEntityToDTOResponse).collect(Collectors.toList());
    }

    @Override
    public AddressDTOResponse getAddressById(Integer addressId) {
       Address address=addressRepository.findById(addressId).orElse(null);
       return addressMapper.fromEntityToDTOResponse(address);
    }

    @Override
    public AddressDTOResponse updateAddress(Integer id, AddressDTORequest addressDTORequest) {
        Address existingAddress=addressRepository.findById(id).orElse(null);
        existingAddress.setCity(addressDTORequest.getCity());
        existingAddress.setCountry(addressDTORequest.getCountry());
        existingAddress.setStreetLine(addressDTORequest.getStreetLine());
        existingAddress.setPostalCode(addressDTORequest.getPostalCode());
        existingAddress.setCountry(addressDTORequest.getCountry());
        Address savedAddress=addressRepository.save(existingAddress);
        return addressMapper.fromEntityToDTOResponse(existingAddress);
    }

    @Override
    public AddressDTOResponse deleteAddress(Integer id) {
        Address address=addressRepository.findById(id).orElse(null);
        addressRepository.delete(address);
        return addressMapper.fromEntityToDTOResponse(address);
    }


}
