package dd.projects.ddshop.dto;

import dd.projects.ddshop.entity.Category;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTOResponse {
    private int id;
    private String name;
    private String description;
    private int price;
    private int availabilityQuantity;
    private Date addedDate;
    private String categoryName;
    private Set<ProductAttributeDTOResponse2> productAttributes;

}
