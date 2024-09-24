insert ignore into inquiries_seq(id,name,mail,content) values
(1,'矢島稔','yajima@gmail.com','矢島稔さんは多摩動物公園昆虫館を創設され、上野動物園水族館長を経て、多摩動物公園園長、東京動物園協会理事長を歴任され、現在、群馬県立ぐんま昆虫の森園長を勤められながら、日本ホタルの会の会長をされています。');

insert ignore into role(id,name) values
(1,'ROLE_GENERAL'),
(2,'ROLE_ADMIN');

insert ignore into user(id,name,password,role_id) values
(1,'クラピカ','$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO',2),
(2,'イルミ','$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO',1);