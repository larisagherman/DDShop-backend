package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.ProductDTORequest;
import dd.projects.ddshop.dto.ProductDTOResponse;
import dd.projects.ddshop.entity.Category;
import dd.projects.ddshop.entity.Product;
import dd.projects.ddshop.mapper.ProductMapper;
import dd.projects.ddshop.repository.CategoryRepository;
import dd.projects.ddshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    public ProductDTOResponse createProduct(ProductDTORequest product) {
        Category categoryID=categoryRepository.findById(product.getCategoryId()).orElseThrow(()->new RuntimeException("Category not found"));
        Product newProduct=productMapper.dtoRequestToEntity(product);
        newProduct.setCategoryId(categoryID);

        Product savedProduct=productRepository.save(newProduct);
        ProductDTOResponse productDTOResponse=productMapper.entityToDTOResponse(savedProduct);
        productDTOResponse.setCategoryName(categoryID.getName());
        return productDTOResponse;
    }
    public List<ProductDTOResponse> getAllProducts() {
        List<Product> products=productRepository.findAll();
        return productMapper.entityListToDTOList(products);
    }
    public ProductDTOResponse getProductById(Integer id) {
        Product product=productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
        return productMapper.entityToDTOResponse(product);
    }
    public ProductDTOResponse updateProduct(Integer id, ProductDTORequest product) {
        Product existingProduct=productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setAvailabilityQuantity(product.getAvailabilityQuantity());
        Product savedProduct=productRepository.save(existingProduct);
        return productMapper.entityToDTOResponse(savedProduct);
    }
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
