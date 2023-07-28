create table client (
id bigint not null auto_increment,
cep varchar(255),
cidade varchar(255),
cpf varchar(255),
email varchar(255),
endereco varchar(255),
estado varchar(255),
fone varchar(255),
nome varchar(255),
primary key (id)) engine=InnoDB;