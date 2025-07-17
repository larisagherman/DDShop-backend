package dd.projects.ddshop.repository;

import dd.projects.ddshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findById(int id);

    User findByEmail(String email);
}
