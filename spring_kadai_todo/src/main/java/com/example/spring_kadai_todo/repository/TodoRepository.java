package com.example.spring_kadai_todo.repository;

import com.example.spring_kadai_todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Integer> {

}
