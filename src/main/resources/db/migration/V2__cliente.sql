CREATE TABLE IF NOT EXISTS cliente
(
    id integer primary key auto_increment,
    nomeCompleto varchar,
    sexo varchar,
    dataNascimento date,
    idade integer,
    cidadeId integer,
    foreign key (cidadeId) references cidade(id)
)