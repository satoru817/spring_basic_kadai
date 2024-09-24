package com.example.springkadaiform.repository;

import com.example.springkadaiform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByName(String username);
}
