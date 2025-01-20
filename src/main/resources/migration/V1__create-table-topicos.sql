create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensagem varchar(400) not null,
    dataCriacao varchar(100) not null,
    estado varchar(100) not null,
    autor varchar(100) not null,
    curso varchar(100) not null,
    ativo tinyint;


    primary key(id)

);




CREATE TABLE usuarios(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL UNIQUE ,
    email varchar(400) not null,
    senha varchar(100) not null
);