package dd.projects.ddshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//to generate getters and setters
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
    private AddressDTOResponse deliveryAddress;
    private AddressDTOResponse billingAddress;
}
