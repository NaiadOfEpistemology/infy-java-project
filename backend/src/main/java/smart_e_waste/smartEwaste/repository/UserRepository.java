package smart_e_waste.smartEwaste.repository;

import smart_e_waste.smartEwaste.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
