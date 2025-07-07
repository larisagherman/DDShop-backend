package dd.projects.ddshop.controller;

import dd.projects.ddshop.dto.CartDTORequest;
import dd.projects.ddshop.dto.CartDTOResponse;
import dd.projects.ddshop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping
    public void createCart(CartDTORequest cartDTORequest) {
        cartService.createCart(cartDTORequest);
    }

    @GetMapping
    public List<CartDTOResponse> getAllCarts() {
        return cartService.getAllCarts();
    }

    @PutMapping("/{id}")
    public void updateCart(@PathVariable("id") Integer id, CartDTORequest cartDTORequest) {
        cartService.updateCart(id, cartDTORequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable("id") Integer id) {
        cartService.deleteCartById(id);
    }

}
