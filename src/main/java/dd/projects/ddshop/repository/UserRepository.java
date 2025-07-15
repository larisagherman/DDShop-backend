package dd.projects.ddshop.repository;

import dd.projects.ddshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findById(int id);

    User findByEmail(String email);
}
