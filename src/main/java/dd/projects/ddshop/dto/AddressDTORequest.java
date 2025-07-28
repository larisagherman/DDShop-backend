package dd.projects.ddshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTORequest {
    private String streetLine;
    private Integer postalCode;
    private String city;
    private String county;
    private String country;
}
