package com.RegCURD.repository;

import com.RegCURD.entity.User;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

@Registered
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsernameOrEmail(String usernameOrEmail, String usernameOrEmail1);
}
