package com.example.springkadaiform.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.context.annotation.Primary;

@Entity
@Data
@Table(name="inquiry_forms")
public class Inquiry {

    @Id//これはなんのために必要なのか？なくしたら、@Entity class must declare or inherit at least one @Id or @EmbeddedId propertyが必要と出た。
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)//これはなんのために必要なのか？データベースに登録するときにIDが必要だが、それをどのように生成するかのルールとなる。
    private Integer id;

    @Column(name="name")
    @NotBlank(message="名前を記入してください")
    @Size(min=2,message="名前は2文字以上にしてください")
    private String name;

    @Column(name="mail")
    @Email(message="メールアドレスの形式が正しくありません。")
    @NotBlank(message="メールアドレスを入力してください。")
    private String mail;

    @Column(name="content")
    @NotBlank(message="お問い合わせ内容を書いてください。")
    @Size(min=5,max=200,message="お問い合わせ内容は5文字以上200文字以下で記入してください。")
    private String content;
}
