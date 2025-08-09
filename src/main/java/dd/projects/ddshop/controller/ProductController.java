package dd.projects.ddshop.controller;

import dd.projects.ddshop.dto.ProductDTORequest;
import dd.projects.ddshop.dto.ProductDTOResponse;
import dd.projects.ddshop.entity.Product;
import dd.projects.ddshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/all")
    List<ProductDTOResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    ProductDTOResponse getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public Page<ProductDTOResponse> getProductsByPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "12") int size,
                                                      @RequestParam(required = false)String category,
                                                      @RequestParam(required = false)List<String> ingredients,
                                                      @RequestParam(required = false)List<String> flavours,
                                                      @RequestParam(defaultValue = "asc") String sortDir,
                                                      @RequestParam(defaultValue = "price")String sortField) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(sortDir),sortField);
        return productService.getProductsByCategory(category,ingredients,flavours,pageable);

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
