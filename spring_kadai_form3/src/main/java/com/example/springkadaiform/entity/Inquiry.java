package com.example.springkadaiform.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="Inquiries")
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    @NotBlank(message="write your name pls")
    @Size(min=2,max = 20,message="the length of a name should be between 2 and 20")
    private String name;

    @Column(name="mail")
    @Email(message="you should write a valid email address here")
    @NotBlank(message="pls write in a email address")
    private String mail;

    @Column(name="content")
    @NotBlank(message="you should write in something")
    @Size(min=5,max=200,message="write in this field between 5 to 200 words")
    private String content;
}
