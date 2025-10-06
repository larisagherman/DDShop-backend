package dd.projects.ddshop.service;

import dd.projects.ddshop.entity.Product;
import dd.projects.ddshop.entity.ProductImage;
import dd.projects.ddshop.repository.ProductImageRepository;
import dd.projects.ddshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductImageService {

    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;

    public void addImageToProduct(Integer productId, String imageUrl) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        ProductImage image = new ProductImage();
        image.setImageUrl(imageUrl);
        image.setProduct(product);
        productImageRepository.save(image);
    }
    public List<String> getAllProductImages() {
        List<ProductImage> productImages = productImageRepository.findAll();
        Map<Integer,String> imageUrls = new HashMap<>();
        for(ProductImage productImage : productImages) {
            imageUrls.put(productImage.getProduct().getId(), productImage.getImageUrl());
        }
        return imageUrls.values().stream().collect(Collectors.toList());

    }

    public List<ProductImage> getImagesByProductId(Integer productId) {
        return productImageRepository.findByProductId(productId);
    }

    public void deleteImage(Integer imageId) {
        productImageRepository.deleteById(imageId);
    }

}

