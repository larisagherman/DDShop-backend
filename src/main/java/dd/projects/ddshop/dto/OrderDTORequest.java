package dd.projects.ddshop.dto;

import dd.projects.ddshop.entity.Address;
import dd.projects.ddshop.entity.Cart;
import dd.projects.ddshop.entity.PaymentType;
import dd.projects.ddshop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTORequest {
    private int userId;
    private int cartId;
    private PaymentType paymentType;
    private AddressDTORequest deliveryAddress;
    private AddressDTORequest invoiceAddress;
    private int totalPrice;
    private Date orderDate;


}
