package dd.projects.ddshop.repository;

import dd.projects.ddshop.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {
   List<ProductImage>  findByProductId(Integer productId);
}
