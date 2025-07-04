package dd.projects.ddshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTORequest {
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
    private String password;
    private AddressDTORequest deliveryAddress;
    private AddressDTORequest billingAddress;
}