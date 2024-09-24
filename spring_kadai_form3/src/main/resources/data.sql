insert ignore into Inquiries(id,name,mail,content)values
(1,'北杜夫','piyopi@gmail.com','私は宇宙人だ。名前はまだない。');

insert ignore into role(id,name) values
(1,'ROLE_ADMIN'),
(2,'ROLE_GENERAL');

insert ignore into user(id,name,password,role_id) values
(1,'ヒソカ','$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO',2),
(2,'ゴン','$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO',1);