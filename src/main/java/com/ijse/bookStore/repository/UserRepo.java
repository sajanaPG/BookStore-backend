package com.ijse.bookStore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ijse.bookStore.entity.Role;
import com.ijse.bookStore.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
    Optional<User> findByRole(Role role);
}
