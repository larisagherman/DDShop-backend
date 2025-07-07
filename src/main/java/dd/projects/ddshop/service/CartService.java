package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.CartDTORequest;
import dd.projects.ddshop.dto.CartDTOResponse;
import dd.projects.ddshop.entity.Cart;
import dd.projects.ddshop.mapper.CartMapper;
import dd.projects.ddshop.repository.CartRepository;
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
    public void createCart(CartDTORequest cartDTORequest) {
        Cart newCart=cartMapper.dtoRequestToEntity(cartDTORequest);
        cartRepository.save(newCart);
    }
    public List<CartDTOResponse> getAllCarts() {
        return cartMapper.entityListToDtoList(cartRepository.findAll());
    }
    public CartDTOResponse getCartById(Integer id) {
        return cartMapper.entityToDto(cartRepository.findById(id).orElse(null));
    }
    public void updateCart(Integer id,CartDTORequest cartDTORequest) {
        Cart existingCart=cartRepository.findById(id).orElse(null);
        existingCart.setTotalPrice(cartDTORequest.getTotalPrice());
        cartRepository.save(existingCart);
    }
    @Transactional
    public void deleteCartById(Integer id) {
        Cart existingCart=cartRepository.findById(id).orElseThrow(()->new RuntimeException("Cart not found"));
        cartRepository.delete(existingCart);
    }

}
