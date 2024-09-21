package com.example.springkadaiform.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Table(name="inquiryForms")
@Entity
public class Form{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    @NotBlank(message="You must write down your name here!")
    private String name;

    @Column(name="mail")
    @Email(message="Your email address is invalid. You must write donw valid email address.")
    @NotBlank(message="You must write down your email address here")
    private String email;

    @Column(name="content")
    @NotBlank(message="You must write down what you want to say...")
    private String content;


}
