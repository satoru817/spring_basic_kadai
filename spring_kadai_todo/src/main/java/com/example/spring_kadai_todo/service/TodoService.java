package com.example.spring_kadai_todo.service;

import com.example.spring_kadai_todo.entity.Todo;
import com.example.spring_kadai_todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> fetchAllTodos(){
        return todoRepository.findAll();
    }

    public void save(Todo todo){
        todoRepository.save(todo);
    }
}
