package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Long> {
    Long countByEmail(String email);
    User findByEmail(String email);
    List<User> findAllByRolesIn(List<Role> roles);
    User findAllByUuid(String uuid);
    void deleteAllByEmail(String email);
}
