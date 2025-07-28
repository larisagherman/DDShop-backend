package dd.projects.ddshop.repository;

import dd.projects.ddshop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByUserId_Id(Integer userId);
}
