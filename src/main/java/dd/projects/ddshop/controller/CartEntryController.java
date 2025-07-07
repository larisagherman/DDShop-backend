package dd.projects.ddshop.controller;

import dd.projects.ddshop.dto.CartEntryDTORequest;
import dd.projects.ddshop.dto.CartEntryDTOResponse;
import dd.projects.ddshop.entity.CartEntry;
import dd.projects.ddshop.service.CartEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart-entries")
@RequiredArgsConstructor
public class CartEntryController {
    private final CartEntryService cartEntryService;
    @PostMapping
    public void createCartEntry(@RequestBody CartEntryDTORequest cartEntryDTORequest) {
        cartEntryService.createCartEntry(cartEntryDTORequest);
    }
    @GetMapping
    public List<CartEntryDTOResponse> getCartEntries() {
        return cartEntryService.getAllCartEntries();
    }
    @PutMapping("/{id}")
    public void updateCartEntry(@PathVariable("id") Integer id,@RequestBody CartEntryDTORequest cartEntryDTORequest) {
        cartEntryService.updateCartEntryById(id, cartEntryDTORequest);
    }
    @DeleteMapping("/{id}")
    public void deleteCartEntry(@PathVariable("id") Integer id) {
        cartEntryService.deleteCartEntryById(id);
    }
}
