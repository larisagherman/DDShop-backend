package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.ProductAttributeDTORequest;
import dd.projects.ddshop.dto.ProductAttributeDTOResponse;
import dd.projects.ddshop.entity.ProductAttribute;
import dd.projects.ddshop.mapper.ProductAttributeMapper;
import dd.projects.ddshop.repository.ProductAttributeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Transactional
public class ProductAttributeService {
    private final ProductAttributeRepository productAttributeRepository;
    private final ProductAttributeMapper productAttributeMapper;

    public void createProductAttribute(ProductAttributeDTORequest productDTORequest) {
        ProductAttribute newProductAttribute = productAttributeMapper.dtoRequestToEntity(productDTORequest);
        ProductAttribute savedProductAttribute = productAttributeRepository.save(newProductAttribute);
    }
    public List<ProductAttributeDTOResponse> getAllProductAttributes() {
        List<ProductAttribute> productAttributes = productAttributeRepository.findAll();
        return productAttributeMapper.entityListToDtoList(productAttributes);
    }
    public ProductAttributeDTOResponse getProductAttributeById(Integer id) {
        ProductAttribute exitingProductAttribute=productAttributeRepository.findById(id).orElseThrow(()-> new RuntimeException("Product attribute not found"));
        return productAttributeMapper.entityToDtoResponse(exitingProductAttribute);
    }
    public void updateProductAttributeById(Integer id, ProductAttributeDTORequest productDTORequest) {
        ProductAttribute existingProductAttribute=productAttributeRepository.findById(id).orElseThrow(()-> new RuntimeException("Product attribute not found"));
        existingProductAttribute.setName(productDTORequest.getName());
        existingProductAttribute.setValue(productDTORequest.getValue());
        ProductAttribute savedProductAttribute=productAttributeRepository.save(existingProductAttribute);
    }
    public void deleteProductAttributeById(Integer id) {
        productAttributeRepository.deleteById(id);
    }

}
