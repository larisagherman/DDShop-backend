package dd.projects.ddshop.repository;

import dd.projects.ddshop.dto.CartDTOResponse;
import dd.projects.ddshop.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
