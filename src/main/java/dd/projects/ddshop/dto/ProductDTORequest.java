package dd.projects.ddshop.dto;

import dd.projects.ddshop.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTORequest {
    private String name;
    private String description;
    private int price;
    private int availabilityQuantity;
    private Date addedDate;
    private int categoryId;
}
