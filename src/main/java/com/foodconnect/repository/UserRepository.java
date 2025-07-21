package com.foodconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.foodconnect.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
