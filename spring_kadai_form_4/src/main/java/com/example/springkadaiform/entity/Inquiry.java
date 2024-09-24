package com.example.springkadaiform.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="InquiryList")
public class Inquiry {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    @NotBlank(message="you should write your name in this field")
    @Size(min=2,max=20,message="your name should be between 2 and 20 words length")
    private String name;

    @Column(name="mail")
    @NotBlank(message="you should write your email address here")
    @Email(message="you should write valid email address")
    private String mail;

    @Column(name="content")
    @NotBlank(message="you should write something")
    private String content;
}
