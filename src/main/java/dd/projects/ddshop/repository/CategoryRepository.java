package dd.projects.ddshop.repository;

import dd.projects.ddshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public Category findByName(String name);
}
