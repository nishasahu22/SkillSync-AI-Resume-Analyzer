package com.skillsync.skillsync.repository;

import com.skillsync.skillsync.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // 🔍 Find user by email (for login & register)
    Optional<User> findByEmail(String email);
}