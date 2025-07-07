package dd.projects.ddshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTOResponse {
    private int id;
    private int streetLine;
    private int postalCode;
    private String city;
    private String county;
    private String country;
}
