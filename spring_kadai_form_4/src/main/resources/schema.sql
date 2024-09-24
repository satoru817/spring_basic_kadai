create table if not exists InquiryList(
    id int not null auto_increment primary key,
    name varchar(50)not null,
    mail varchar(50) not null,
    content varchar(255) not null);

create table if not exists role(
    id int not null primary key auto_increment,
    name varchar(50) not null);

create table if not exists user(
    id int not null auto_increment primary key,
    name varchar(50) not null,
    password varchar(255) not null,
    roleId int not null,
    foreign key(roleId)
    references role(id));