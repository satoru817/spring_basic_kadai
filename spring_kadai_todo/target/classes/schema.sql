create table if not exists todos(
    id int not null auto_increment primary key,
    title varchar(50) not null,
    priority enum('高','中','低') not null default '中',
    status enum('未着手','着手中','完了') not null default '未着手');
