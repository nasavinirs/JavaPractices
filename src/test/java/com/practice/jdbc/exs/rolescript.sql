drop table if exists role;
create table role(
id  int not null,
name varchar (255) not null,
primary key(id)
);

insert into role values(1,'Manager');
insert into role values(2,'Admin');
insert into role values(3,'Shipper');
insert into role values(4,'Maritime Operator');



