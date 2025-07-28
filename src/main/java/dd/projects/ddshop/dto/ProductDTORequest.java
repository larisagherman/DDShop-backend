package dd.projects.ddshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;
import java.util.Set;

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
    private List<ProductImageDTORequest2> imageUrls;
    private Set<ProductAttributeDTORequest> productAttributes;
}
