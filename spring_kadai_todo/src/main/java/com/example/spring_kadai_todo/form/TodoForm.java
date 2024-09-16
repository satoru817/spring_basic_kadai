package com.example.spring_kadai_todo.form;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class TodoForm {
    @NotEmpty(message="content must not be empty")
    @Size(min=5,message="content must be at least 5 characters long")
    private String title;

    private String priority;

    private String status;

}

