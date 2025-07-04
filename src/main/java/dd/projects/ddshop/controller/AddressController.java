package dd.projects.ddshop.controller;

import dd.projects.ddshop.dto.AddressDTORequest;
import dd.projects.ddshop.dto.AddressDTOResponse;
import dd.projects.ddshop.entity.Address;
import dd.projects.ddshop.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;
    @PostMapping
    public AddressDTOResponse createAddress(@RequestBody AddressDTORequest addressDTORequest) {
        return addressService.createAddress(addressDTORequest);
    }
    @GetMapping
    public List<AddressDTOResponse> getAddresses() {
        return addressService.getAddresses();
    }

    @GetMapping("{id}")
    public AddressDTOResponse getAddressById(@PathVariable Integer id) {
        return addressService.getAddressById(id);
    }
    @PostMapping("{id}")
    public AddressDTOResponse updateAddress(@PathVariable Integer id,@RequestBody AddressDTORequest addressDTORequest) {
        return addressService.updateAddress(id,addressDTORequest);
    }
    @DeleteMapping("{id}")
    public void deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
    }
}
