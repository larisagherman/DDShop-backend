package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.ProductAttributeDTORequest;
import dd.projects.ddshop.dto.ProductAttributeDTOResponse;
import dd.projects.ddshop.dto.ProductDTORequest;
import dd.projects.ddshop.dto.ProductDTOResponse;
import dd.projects.ddshop.entity.Category;
import dd.projects.ddshop.entity.Product;
import dd.projects.ddshop.entity.ProductAttribute;
import dd.projects.ddshop.mapper.ProductMapper;
import dd.projects.ddshop.repository.CategoryRepository;
import dd.projects.ddshop.repository.ProductAttributeRepository;
import dd.projects.ddshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;
    private final ProductAttributeRepository productAttributeRepository;

    public ProductDTOResponse createProduct(ProductDTORequest product) {
        Category categoryID = categoryRepository.findById(product.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
        Product newProduct = productMapper.dtoRequestToEntity(product);

        Set<ProductAttribute> productAttributes = new HashSet<>();
        Set<ProductAttribute> attributes = new HashSet<>();
        for (ProductAttributeDTORequest attributeDTO : product.getProductAttributes()) {
            ProductAttribute attribute = productAttributeRepository
                    .findByNameAndValue(attributeDTO.getName(), attributeDTO.getValue())
                    .orElseGet(() -> {
                        ProductAttribute newAttribute = new ProductAttribute();
                        newAttribute.setName(attributeDTO.getName());
                        newAttribute.setValue(attributeDTO.getValue());
                        return productAttributeRepository.save(newAttribute);
                    });
            attributes.add(attribute);
        }

        newProduct.setCategoryId(categoryID);
        newProduct.setProductAttributeSet(attributes);
// Set product on each image
        if (newProduct.getProductImageUrls() != null) {
            newProduct.getProductImageUrls().forEach(image -> image.setProduct(newProduct));
        }
        Product savedProduct = productRepository.save(newProduct);
        ProductDTOResponse productDTOResponse = productMapper.entityToDTOResponse(savedProduct);
        productDTOResponse.setCategoryName(categoryID.getName());
        return productDTOResponse;
    }

    public List<ProductDTOResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.entityListToDTOList(products);
    }
    public Page<ProductDTOResponse> getAllProductsByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Product> productsPage = productRepository.findAll(pageable);

        List <ProductDTOResponse> dtoList=productMapper.entityListToDTOList(productsPage.getContent());
        return new PageImpl<>(dtoList, pageable, productsPage.getTotalElements());
    }

    public ProductDTOResponse getProductById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.entityToDTOResponse(product);
    }

    public ProductDTOResponse updateProduct(Integer id, ProductDTORequest product) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setAvailabilityQuantity(product.getAvailabilityQuantity());
        Product savedProduct = productRepository.save(existingProduct);
        return productMapper.entityToDTOResponse(savedProduct);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
