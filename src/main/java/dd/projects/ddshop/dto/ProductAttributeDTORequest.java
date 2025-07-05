package dd.projects.ddshop.dto;

import dd.projects.ddshop.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttributeDTORequest {
    private String name;
    private String value;
}
