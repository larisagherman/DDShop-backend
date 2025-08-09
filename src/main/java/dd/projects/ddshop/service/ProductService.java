package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.ProductAttributeDTORequest;
import dd.projects.ddshop.dto.ProductDTORequest;
import dd.projects.ddshop.dto.ProductDTOResponse;
import dd.projects.ddshop.entity.Category;
import dd.projects.ddshop.entity.Product;
import dd.projects.ddshop.entity.ProductAttribute;
import dd.projects.ddshop.mapper.ProductMapper;
import dd.projects.ddshop.repository.CategoryRepository;
import dd.projects.ddshop.repository.ProductAttributeRepository;
import dd.projects.ddshop.repository.ProductRepository;
import dd.projects.ddshop.specifications.ProductSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Page<ProductDTOResponse> getProductsByCategory(
            String category,
            List<String> ingredients,
            List<String> flavours,
            Pageable pageable
    ) {
        Specification<Product> spec = null;

        if (category != null && !category.isEmpty()) {
            spec = ProductSpecifications.hasCategory(category);
        }

        if (ingredients != null && !ingredients.isEmpty()) {
            Specification<Product> ingredientSpec = ProductSpecifications.hasIngredient(ingredients);
            spec = (spec == null) ? ingredientSpec : spec.and(ingredientSpec);
        }

        if (flavours != null && !flavours.isEmpty()) {
            Specification<Product> flavourSpec = ProductSpecifications.hasFlavour(flavours);
            spec = (spec == null) ? flavourSpec : spec.and(flavourSpec);
        }

        Page<Product> filteredProductPage = productRepository.findAll(spec, pageable);
        List<ProductDTOResponse> dtoList = productMapper.entityListToDTOList(filteredProductPage.getContent());

        return new PageImpl<>(dtoList, pageable, filteredProductPage.getTotalElements());
    }

}
