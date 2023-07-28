create table parts (
id bigint not null auto_increment,
brand varchar(255),
model varchar(255),
name varchar(255),
price float(53),
quantity integer,
primary key (id)) engine=InnoDB;