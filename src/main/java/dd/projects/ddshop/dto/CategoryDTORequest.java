package dd.projects.ddshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryDTORequest {
    private String name;
    private String description;
}
