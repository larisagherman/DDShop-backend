package dd.projects.ddshop.dto;

import dd.projects.ddshop.entity.Cart;
import dd.projects.ddshop.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartEntryDTOResponse {
    private int id;
    private int productId;
    private int quantity;
    private int pricePerPiece;
    private int totalPricePerEntry;
    private int cartId;

}
