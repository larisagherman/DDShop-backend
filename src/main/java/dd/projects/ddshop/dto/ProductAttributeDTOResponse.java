package dd.projects.ddshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttributeDTOResponse {
    private String id;
    private String name;
    private String value;
    private Set<ProductDTOResponse> productsSet;
}
