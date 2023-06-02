--2023-05-30
create table member(
id varchar(30) not null,
pw varchar(50) not null,
name varchar(20) not null,
email varchar(100) not null,
phone varchar(30),
regdate datetime default now(),
event int not null,
auth int default 0,
Primary key(id));

--2023-05-31
create table board(
bno int not null auto_increment,
title varchar(100) not null,
writer varchar(100) not null,
regdate datetime default now(),
content varchar(300),
readcount int default 0,
image varchar(300),
Primary key(bno));

create table comment(
cno int not null auto_increment,
bno int,
writer varchar(100) not null,
content varchar(300),
regdate datetime default now(),
Primary key(cno));
