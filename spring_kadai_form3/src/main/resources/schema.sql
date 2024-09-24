create table if not exists Inquiries(
    id int not null primary key auto_increment,
    name varchar(50) not null,
    mail varchar(50)  not null,
    content varchar(255) not null);

create table if  not exists role(
    id int not null auto_increment primary key,
    name varchar(50) not null);

create table if not exists user(
    id int not null primary key auto_increment,
    name varchar(50) not null,
    password varchar(255) not null,
    role_id int not null ,
    foreign key(role_id)
    references role(id));