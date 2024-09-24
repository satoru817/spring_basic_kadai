package com.example.springkadaiform.repository;

import com.example.springkadaiform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findByUserName(String username);
}
