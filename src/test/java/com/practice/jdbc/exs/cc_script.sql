drop table if exists invoice;
create table invoice(
id int not null,
customer_name varchar(30) not null,
payment_attempts int not null,
total_amount double not null,
balance double not null,
status varchar(30) not null,
primary key(id));

insert into invoice (id,customer_name,payment_attempts,total_amount,balance,status) values ( 1,'Shravan',1,45000.00,30000.00,'Pending');
insert into invoice (id,customer_name,payment_attempts,total_amount,balance,status) values ( 2,'Rafael',0,5000.00,5000.00,'Pending');
insert into invoice (id,customer_name,payment_attempts,total_amount,balance,status) values ( 3,'Tori',1,800.00,800.00,'Completed');
insert into invoice (id,customer_name,payment_attempts,total_amount,balance,status) values ( 4,'John',2,15000.00,10000.00,'Pending');
insert into invoice (id,customer_name,payment_attempts,total_amount,balance,status) values ( 5,'Jack',0,900.00,900.00,'Pending');
insert into invoice (id,customer_name,payment_attempts,total_amount,balance,status) values ( 6,'Steffi',1,1000.00,500.00,'Pending');
insert into invoice (id,customer_name,payment_attempts,total_amount,balance,status) values ( 7,'Roger',2,3000.00,3000.00,'Completed');
insert into invoice (id,customer_name,payment_attempts,total_amount,balance,status) values ( 8,'Roger',1,1000.00,500.00,'Pending');
insert into invoice (id,customer_name,payment_attempts,total_amount,balance,status) values ( 9,'Rafael',1,2000.00,1000.00,'Pending');
insert into invoice (id,customer_name,payment_attempts,total_amount,balance,status) values ( 10,'Steffi',0,1000.00,1000.00,'Pending');


