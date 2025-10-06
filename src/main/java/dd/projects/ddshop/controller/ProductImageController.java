package dd.projects.ddshop.controller;

import dd.projects.ddshop.dto.ProductImageDTORequest;
import dd.projects.ddshop.entity.ProductImage;
import dd.projects.ddshop.service.ProductImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product-image")
@CrossOrigin(origins = "http://localhost:3000",
        allowCredentials = "true"
)
@RequiredArgsConstructor
public class ProductImageController {
    private final ProductImageService productImageService;
    @PutMapping("/product/{productId}")
    public void addImageToProduct(@PathVariable("productId") Integer productId,@RequestParam String imageUrl) {
        productImageService.addImageToProduct(productId,imageUrl);
    }
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductImage> > getProductImage(@PathVariable("productId") Integer productId) {
        List<ProductImage> images = productImageService.getImagesByProductId(productId);
        return ResponseEntity.ok(images);
    }
    @GetMapping
    public ResponseEntity<List<ProductImageDTORequest>> getProductImages() {
        return ResponseEntity.ok(productImageService.getAllProductImages());
    }

}
