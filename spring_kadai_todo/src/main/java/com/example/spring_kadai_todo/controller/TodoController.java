package com.example.spring_kadai_todo.controller;

import com.example.spring_kadai_todo.entity.Todo;
import com.example.spring_kadai_todo.form.TodoForm;
import com.example.spring_kadai_todo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping("")
    public String viewAllTodos(Model model){
        List<Todo> todoList = todoService.fetchAllTodos();
        TodoForm todoForm = new TodoForm();
        model.addAttribute("todoList",todoList);
        model.addAttribute("todoForm",todoForm);
        return "todoList";
    }

    @PostMapping("/register")
    public String registerTodo(@ModelAttribute @Validated TodoForm todoForm ,
                               BindingResult bindingResult,
                               Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("todoForm",todoForm);
            List<Todo> todoList = todoService.fetchAllTodos();
            model.addAttribute("todoList",todoList);
            return "todoList";
        }else{
            Todo todo = new Todo();
            todo.setTitle(todoForm.getTitle());
            todo.setPriority(todoForm.getPriority());
            todo.setStatus(todoForm.getStatus());
            todoService.save(todo);
            return "redirect:/todo";
        }
    }
}
