create table if not exists inquiry_forms(
    id int not null auto_increment primary key,
    name varchar(255) not null,
    mail varchar(255) not null,
    content varchar(511) not null);