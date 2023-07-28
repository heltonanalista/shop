create table bike_order (
id bigint not null auto_increment,
shop_date datetime(6),
total_price float(53),
bike_model_id bigint,
client_model_id bigint,
primary key (id)) engine=InnoDB;