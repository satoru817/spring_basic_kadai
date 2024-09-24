package com.example.springkadaiform.repository;

import com.example.springkadaiform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByUserName(String userName);
}
