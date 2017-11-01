drop table if exists privilege;



create table privilege

(id int not null AUTO_INCREMENT,
name varchar(255) not null,primary key(id));


insert into privilege(name) values('Create');



insert into privilege(name) values('Process');



insert into privilege(name) values('Schedule');



insert into privilege(name) values('Cancel');



insert into privilege(name) values('View');

drop table if exists role;



create table role

(id int not null AUTO_INCREMENT,
name varchar(255) not null,primary key(id));



drop table if exists role_privilege;



create table role_privilege

(role_id int not null references role(id),

privilege_id int not null references privilege(id),

primary key(role_id,privilege_id));
