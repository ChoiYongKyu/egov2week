create database spring;

use spring;

create table users(
userid varchar(30) not null primary key,
name varchar(50) not null,
gender varchar(10),
city varchar(100)
)default charset=utf8;

desc users;

select * from users;

truncate users;

SELECT VERSION();