drop table if exists order_line;
drop table if exists purchase_order;
drop table if exists item;

create table item(
id int not null auto_increment,
name varchar(30) not null,
available_quantity int not null,
price double not null,
primary key(id)
);

create table purchase_order(
id int not null auto_increment,
order_date date not null,
created_date date not null,
number_of_items int not null,
status varchar(30),
total_amount double not null,
customer_name varchar(30) not null,
mobile_number varchar(30) not null,
primary key(id)
); 


create table order_line(
id int not null auto_increment,
price double not null,
quantity int not null,
item_id int not null,
purchase_order_id int not null,
primary key(id),
foreign key(item_id)
references item(id),
foreign key(purchase_order_id)
references purchase_order(id)
);

insert into item (name,available_quantity,price) values ('Voltas 1.4 Ton 3',10,27900.00);    
insert into item (name,available_quantity,price) values ('Onida 1.5 Ton 3 Star',20,32490.00);  
insert into item (name,available_quantity,price) values ('Micromax Split AC',30,25000.00); 
insert into item (name,available_quantity,price) values ('Kenstar 1.5 Ton 5',20,26990.00);  
insert into item (name,available_quantity,price) values ('LG 1 Ton Inverter AC',20,27900.00); 
insert into item (name,available_quantity,price) values ('Moto G Play',10,7999.00); 

