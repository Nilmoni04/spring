package com.Spring.Spring_Security_demo.dao;

import com.Spring.Spring_Security_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
