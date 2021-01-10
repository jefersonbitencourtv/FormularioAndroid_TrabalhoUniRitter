create database android;
create table aluno
(
    id             int          NOT null auto_increment,
    nome           varchar(255) NOT null,
    email          varchar(255) NOT null,
    datanascimento varchar(15)  NOT null,
    identidade     int(15)      NOT null,
    celular        int(9)       NOT null,
    telefone       int(8)       NOT null,
    endereco       varchar(250) NOT null,
    numero         int(20)      NOT null,
    complemento    varchar(100) NOT null,
    bairro         varchar(100) NOT null,
    estado         varchar(100) NOT null,
    cidade         varchar(100) NOT null,
    nome_escola    varchar(255) NOT null,
    bairro_escola  varchar(255) NOT null,
    ano            varchar(40)  NOT null,
    turma          varchar(10)  NOT null,
    perfil_escola  varchar(50)  NOT null,
    realistico     varchar(100) NOT null,
    investigativo  varchar(100) NOT null,
    empreendedor   varchar(100) NOT null,
    convencional   varchar(100) NOT null,
    artistico      varchar(100) NOT null,
    social         varchar(100) NOT null,

    PRIMARY KEY (id)
);


