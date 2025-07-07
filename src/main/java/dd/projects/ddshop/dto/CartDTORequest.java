package dd.projects.ddshop.dto;

import dd.projects.ddshop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTORequest {
    private int userId;
    private int totalPrice;

}
