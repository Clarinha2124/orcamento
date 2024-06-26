Create table lancamento(
id bigint not null primary key auto_increment,
datalancamento date,
tipolancamento varchar(10),
id_cliente int not null,
valorlancamento decimal(12,2)
);

alter table cliente add constraint FK_municipio_cliente foreign key (id_municipio)
references municipio(id);

alter table lancamento add constraint FK_cliente_lancamento foreign key (id_cliente)
references cliente(id);