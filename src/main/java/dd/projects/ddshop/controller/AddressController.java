package dd.projects.ddshop.controller;

import dd.projects.ddshop.dto.AddressDTO;
import dd.projects.ddshop.entity.Address;
import dd.projects.ddshop.service.AddressService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
@Data
public class AddressController {
    private final AddressService addressService;
    @GetMapping
    public List<AddressDTO> getAddresses() {
        return addressService.getAddresses();
    }
}
