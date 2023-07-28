create table manutencao (
id bigint not null auto_increment,
date datetime(6),
description varchar(255),
labor_cost float(53),
total_price float(53),
bike_id bigint,
client_id bigint,
primary key (id)) engine=InnoDB;