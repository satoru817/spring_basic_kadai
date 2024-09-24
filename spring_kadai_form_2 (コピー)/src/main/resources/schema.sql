create table if not exists inquiries_seq (
    id int not null auto_increment primary key,
    name varchar(50) not null,
    mail varchar(50) not null,
    content varchar(255) not null);