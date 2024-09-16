package com.example.spring_kadai_todo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name="todos")
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="priority")
    private String priority;

    @Column(name="status")
    private String status;
}
