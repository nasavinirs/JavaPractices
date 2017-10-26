drop table if exists user;
drop table if exists contact;
drop table if exists role;
create table role(
id int not null auto_increment,
name varchar(30) not null,
primary key(id));

create table contact(
id int not null auto_increment,
street varchar(30) not null,
city varchar(30) not null,
state varchar(30) not null,
primary key(id));


create table user(
id int not null auto_increment,
name varchar(30) not null,
contact_id int not null,
role_id int not null,
primary key(id),
foreign key(contact_id)
references contact(id),
foreign key(role_id)
references role(id)); 


insert into role (name) values ('Managing Director'); 
insert into role (name) values ('Manager'); 
insert into role (name) values ('Accountant'); 
insert into role (name) values ('Receptionist'); 

insert into contact (street,city,state) values ('10/a Eatteri Road','Salem','TamilNadu'); 
insert into contact (street,city,state) values ('43/d warren road','Chennai','TamilNadu'); 
insert into contact (street,city,state) values ('9/5A Hosur Road','Bangalore','Karnataka'); 
insert into contact (street,city,state) values ('GC Road','Belgaum','Karnataka'); 
insert into contact (street,city,state) values ('Hosa Road','Ankola','Karnataka'); 
insert into contact (street,city,state) values ('RSP Road','Salem','TamilNadu'); 

insert into user (name,role_id,contact_id) values ('Mathew',1,1);
insert into user (name,role_id,contact_id) values ('Jane',2,3);        
insert into user (name,role_id,contact_id) values ('Jennifer',2,2);        
insert into user (name,role_id,contact_id) values ('Bula',3,4);     
insert into user (name,role_id,contact_id) values ('Rehaana',4,5);     
insert into user (name,role_id,contact_id) values ('Sinjana',3,6);  

