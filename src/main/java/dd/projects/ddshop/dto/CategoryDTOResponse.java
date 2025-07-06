package dd.projects.ddshop.dto;

import dd.projects.ddshop.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
