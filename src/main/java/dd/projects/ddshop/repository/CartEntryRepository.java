package dd.projects.ddshop.repository;

import dd.projects.ddshop.entity.CartEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartEntryRepository extends JpaRepository<CartEntry, Integer> {
}
