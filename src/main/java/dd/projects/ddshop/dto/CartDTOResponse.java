package dd.projects.ddshop.dto;

import dd.projects.ddshop.entity.CartEntry;
import dd.projects.ddshop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTOResponse {
    private int id;
    private int userId;
    private int totalPrice;
    private List<CartEntryDTOResponse> cartEntries;


}
