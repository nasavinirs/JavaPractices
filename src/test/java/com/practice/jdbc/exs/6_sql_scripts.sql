drop table if exists shipment;
drop table if exists shipment_status;


create table shipment_status(
id int not null auto_increment,
name varchar(30) not null,
code varchar(30) not null,	
primary key(id));

create table shipment(
id int not null auto_increment,
name varchar(30) not null,
arrival_port_name varchar(30) not null,
departure_port_name varchar(30) not null,
cost double not null,
shipment_status_id int not null,
primary key(id),
foreign key(shipment_status_id)
references shipment_status(id)
);




insert into shipment_status(name,code)values('Arrived at destination',6);
insert into shipment_status(name,code)values('Late',37);
insert into shipment_status(name,code)values('Transfer',29);
insert into shipment_status(name,code)values('At origin',25);
insert into shipment_status(name,code)values('Delivered',23);
insert into shipment_status(name,code)values('Possible Delay Notification',33);


insert into shipment(name,arrival_port_name,departure_port_name,cost,shipment_status_id)values('General cargo','Chennai','Mumbai',1200.0,1);
insert into shipment(name,arrival_port_name,departure_port_name,cost,shipment_status_id)values('Laptop','Mumbai','Cochin',100.0,2);
insert into shipment(name,arrival_port_name,departure_port_name,cost,shipment_status_id)values('Livestock','Pune','Chennai',150.0,3);
insert into shipment(name,arrival_port_name,departure_port_name,cost,shipment_status_id)values('Tankers','Mumbai','Cochin',250.0,4);
insert into shipment(name,arrival_port_name,departure_port_name,cost,shipment_status_id)values('Coasters','Chennai','Pune',900.0,5);
insert into shipment(name,arrival_port_name,departure_port_name,cost,shipment_status_id)values('Charter','Mumbai','Pune',800.0,2);

