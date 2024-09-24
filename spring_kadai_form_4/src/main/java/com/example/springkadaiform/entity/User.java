package com.example.springkadaiform.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String userName;

    @Column(name="password")
    private String password;

    @ManyToOne
    @JoinColumn(name="roleId")
    private Role role;
}
