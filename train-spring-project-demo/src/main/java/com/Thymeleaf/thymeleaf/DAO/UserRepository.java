package com.Thymeleaf.thymeleaf.DAO;
import com.Thymeleaf.thymeleaf.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findAllByOrderByIdAsc();
    User findByEmail(String email);
}