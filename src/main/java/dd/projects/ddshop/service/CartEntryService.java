package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.CartEntryDTORequest;
import dd.projects.ddshop.dto.CartEntryDTOResponse;
import dd.projects.ddshop.entity.CartEntry;
import dd.projects.ddshop.mapper.CartEntryMapper;
import dd.projects.ddshop.repository.CartEntryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CartEntryService {
    private final CartEntryRepository cartEntryRepository;
    private final CartEntryMapper cartEntryMapper;

    public void createCartEntry(CartEntryDTORequest cartEntryDTORequest) {
        CartEntry newCartEntry = cartEntryMapper.dtoRequestToEntity(cartEntryDTORequest);
        cartEntryRepository.save(newCartEntry);
    }

    public List<CartEntryDTOResponse> getAllCartEntries() {
        return cartEntryMapper.entityListToDtoList(cartEntryRepository.findAll());
    }

    public void updateCartEntryById(Integer id, CartEntryDTORequest cartEntryDTORequest) {
        CartEntry existingCartEntry = cartEntryRepository.findById(id).orElse(null);
        existingCartEntry.setQuantity(cartEntryDTORequest.getQuantity());
        existingCartEntry.setTotalPricePerEntry(cartEntryDTORequest.getTotalPricePerEntry());
        existingCartEntry.setPricePerPiece(cartEntryDTORequest.getPricePerPiece());
        CartEntry updatedCartEntry = cartEntryRepository.save(existingCartEntry);
    }

    @Transactional
    public void deleteCartEntryById(Integer id) {
        CartEntry existingCartEntry = cartEntryRepository.findById(id).orElseThrow(() -> new RuntimeException("Cart Entry Not Found"));
        cartEntryRepository.delete(existingCartEntry);
    }
}
