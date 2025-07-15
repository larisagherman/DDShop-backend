package dd.projects.ddshop.controller;

import dd.projects.ddshop.dto.ProductDTORequest;
import dd.projects.ddshop.dto.ProductDTOResponse;
import dd.projects.ddshop.entity.Product;
import dd.projects.ddshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000",
        allowCredentials = "true"
)

public class ProductController {
    private final ProductService productService;

    @PostMapping
    void createProduct(@RequestBody ProductDTORequest productDTORequest) {
        productService.createProduct(productDTORequest);
    }

    @GetMapping
    List<ProductDTOResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    ProductDTOResponse getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @PutMapping("{id}")
    ProductDTOResponse updateProduct(@PathVariable Integer id, @RequestBody ProductDTORequest productDTORequest) {
        return productService.updateProduct(id, productDTORequest);
    }

    @DeleteMapping("{id}")
    void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

}
