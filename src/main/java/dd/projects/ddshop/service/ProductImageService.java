package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.ProductImageDTORequest;
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

    public List<ProductImageDTORequest> getAllProductImages() {
        List<ProductImage> productImages = productImageRepository.findAll();
        List<ProductImageDTORequest> imageUrls = productImageRepository.findAll().stream()
                .collect(Collectors.groupingBy(pi -> pi.getProduct().getId(),
                        LinkedHashMap::new,
                        Collectors.mapping(ProductImage::getImageUrl, Collectors.toList())))
                .entrySet().stream()
                .map(entry -> new ProductImageDTORequest(entry.getValue().get(0), entry.getKey()))
                .collect(Collectors.toList());

        return imageUrls;

    }

    public List<ProductImage> getImagesByProductId(Integer productId) {
        return productImageRepository.findByProductId(productId);
    }

    public void deleteImage(Integer imageId) {
        productImageRepository.deleteById(imageId);
    }

}

