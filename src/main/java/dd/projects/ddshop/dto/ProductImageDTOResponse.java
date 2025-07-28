package dd.projects.ddshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImageDTOResponse {
    private Integer id;
    private String imageUrl;
    private Integer productId;
}
