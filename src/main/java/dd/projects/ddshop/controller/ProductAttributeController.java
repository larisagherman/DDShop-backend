package dd.projects.ddshop.controller;

import dd.projects.ddshop.dto.ProductAttributeDTORequest;
import dd.projects.ddshop.dto.ProductAttributeDTOResponse;
import dd.projects.ddshop.entity.ProductAttribute;
import dd.projects.ddshop.service.ProductAttributeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-attribute")
@AllArgsConstructor
public class ProductAttributeController {
    private final ProductAttributeService productAttributeService;
    @PostMapping
    void createProductAttribute(@RequestBody ProductAttributeDTORequest productAttributeDTORequest) {
        productAttributeService.createProductAttribute(productAttributeDTORequest);
    }
    @GetMapping
    List<ProductAttributeDTOResponse> getProductAttributes() {
        return productAttributeService.getAllProductAttributes();
    }
    @GetMapping("{id}")
    ProductAttributeDTOResponse getProductAttributeById(@RequestParam Integer id) {
        return productAttributeService.getProductAttributeById(id);
    }
    @PostMapping("{id}")
    void updateProductAttribute(@PathVariable Integer id, @RequestBody ProductAttributeDTORequest productAttributeDTORequest) {
        productAttributeService.updateProductAttributeById(id, productAttributeDTORequest);
    }
    @DeleteMapping
    void deleteProductAttributeById(@RequestParam Integer id) {
        productAttributeService.deleteProductAttributeById(id);
    }

}
