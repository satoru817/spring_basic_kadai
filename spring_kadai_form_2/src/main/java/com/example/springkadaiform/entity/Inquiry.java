package com.example.springkadaiform.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="inquiries")
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//GenerationType.AUTOにするとUnknown column 'next_val' in 'field list'というわけのわからないエラーが出た
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    @NotBlank(message="お名前を入力してください")
    @Size(min=2,max=20,message="名前は2文字以上20文字以内で記入してください")
    private String name;

    @Column(name="mail")
    @NotBlank(message="メールアドレスと記入してください")
    @Email(message="正しい形式のメールアドレスを記入してください")
    private String mail;

    @Column(name="content")
    @NotBlank(message="お問い合わせ内容を記入してください")
    @Size(min=5,max=200,message="お問い合わせ内容は5文字以上、200文字以下で記入してください。")
    private String content;
}
