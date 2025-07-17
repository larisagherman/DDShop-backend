package dd.projects.ddshop.controller;

import dd.projects.ddshop.dto.CartDTORequest;
import dd.projects.ddshop.dto.CartDTORequestOnlyWithTotalPrice;
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
    public void createCart(@RequestBody CartDTORequest cartDTORequest) {
        System.out.println("Received userId: " + cartDTORequest.getUserId());
        cartService.createCart(cartDTORequest);
    }

    @GetMapping
    public List<CartDTOResponse> getAllCarts() {
        return cartService.getAllCarts();
    }

    @PutMapping("/{id}")
    public void updateCart(@PathVariable("id") Integer id,@RequestBody CartDTORequestOnlyWithTotalPrice cartDtoWithOnlyTotalPrice) {
        cartService.updateTotalPriceCart(id, cartDtoWithOnlyTotalPrice);
    }
    @GetMapping("/user/{userId}")
    public CartDTOResponse getCartByUserId(@PathVariable("userId") Integer userId) {
        return cartService.getCartByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable("id") Integer id) {
        cartService.deleteCartById(id);
    }

}
