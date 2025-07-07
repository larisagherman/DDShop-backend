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
//We have this DTO for the product response
//when we get the product attributes and all the attribute's products (we do not want this)
public class ProductAttributeDTOResponse2 {
    private String id;
    private String name;
    private String value;
}
