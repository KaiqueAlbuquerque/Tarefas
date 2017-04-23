create database predio

use predio

use predio

create table if not exists conjunto
(
	andar					int(3) primary key AUTO_INCREMENT,
    tamanho					decimal(10,2),
    salas					int,
    valor					decimal(10,2),
    observacao				varchar(200),
    situacao				binary
);
