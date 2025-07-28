package dd.projects.ddshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class CategoryDTOResponse {
    private int id;
    private String name;
    private String description;
    private List<ProductDTOResponse> products;
}
