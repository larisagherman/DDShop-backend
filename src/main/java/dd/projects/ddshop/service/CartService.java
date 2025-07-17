package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.CartDTORequest;
import dd.projects.ddshop.dto.CartDTORequestOnlyWithTotalPrice;
import dd.projects.ddshop.dto.CartDTOResponse;
import dd.projects.ddshop.entity.Cart;
import dd.projects.ddshop.entity.User;
import dd.projects.ddshop.mapper.CartMapper;
import dd.projects.ddshop.repository.CartRepository;
import dd.projects.ddshop.repository.UserRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class CartService {
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final UserRepository userRepository;

    public void createCart(CartDTORequest cartDTORequest) {
        System.out.println("Received userId: " + cartDTORequest.getUserId()); // Add this line

        User userId = userRepository.findById(cartDTORequest.getUserId()).orElseThrow(()-> new RuntimeException("User with id " + cartDTORequest.getUserId() + " not found"));

        Cart newCart = cartMapper.dtoRequestToEntity(cartDTORequest);
        newCart.setUserId(userId);
        cartRepository.save(newCart);
    }

    public List<CartDTOResponse> getAllCarts() {
        return cartMapper.entityListToDtoList(cartRepository.findAll());
    }

    public CartDTOResponse getCartById(Integer id) {
        Cart foundCart = cartRepository.findById(id).orElse(null);
        return cartMapper.entityToDto(cartRepository.findById(id).orElse(null));
    }

    public void updateTotalPriceCart(Integer id, CartDTORequestOnlyWithTotalPrice cartDtoWithOnlyTotalPrice) {
        Cart existingCart = cartRepository.findById(id).orElse(null);
        existingCart.setTotalPrice(cartDtoWithOnlyTotalPrice.getTotalPrice());
        cartRepository.save(existingCart);
    }

    @Transactional
    public void deleteCartById(Integer id) {
        Cart existingCart = cartRepository.findById(id).orElseThrow(() -> new RuntimeException("Cart not found"));
        cartRepository.delete(existingCart);
    }
    public CartDTOResponse getCartByUserId(Integer userId) {
        User foundUser = userRepository.findById(userId).orElse(null);
        Cart foundCart = cartRepository.findById(foundUser.getCart().getId()).orElse(null);
        return cartMapper.entityToDto(foundCart);
    }

}
