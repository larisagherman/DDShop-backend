package dd.projects.ddshop.repository;

import dd.projects.ddshop.dto.ProductDTOResponse;
import dd.projects.ddshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<Product, Integer> , JpaSpecificationExecutor<Product> {
}
