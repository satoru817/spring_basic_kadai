insert ignore into InquiryList(id,name,mail,content) values
(1,'ヒソカ=モロウ','hisoka@hunter.com','そんな目でみつめるなよ。興奮しちゃうだろう。');

insert ignore into role(id,name) values
(1,'ROLE_GENERAL'),
(2,'ROLE_ADMIN');

insert ignore into user(id,name,password,roleId) values
(1,'ゴン','$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO',1),
(2,'キルア','$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO',1),
(3,'ネテロ','$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO',2);

