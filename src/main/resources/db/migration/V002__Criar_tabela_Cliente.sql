Create table cliente(
id int not null primary key auto_increment,
nome varchar(100),
endereco varchar(120),
numero varchar(50),
bairro varchar(80),
id_municipio int not null,
telefone varchar(30),
celular varchar(30)
);
