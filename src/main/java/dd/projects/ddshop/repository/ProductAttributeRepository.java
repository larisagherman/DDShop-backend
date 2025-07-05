package dd.projects.ddshop.repository;

import dd.projects.ddshop.entity.ProductAttribute;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Integer> {
    ProductAttribute findByName(String name);
    Optional<ProductAttribute> findByNameAndValue(String name, String value);
    List<ProductAttribute> findAll();
}
