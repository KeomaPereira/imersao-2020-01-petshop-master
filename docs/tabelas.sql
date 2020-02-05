create table unidade (`id` int auto_increment,`nome` varchar(50), `endereco` varchar(200), primary key (`id`) );

insert into unidade (nome, endereco) values ("Zona Sul", "Rua Mario Totta");

select id,nome,endereco from unidade;

delete from unidade Where id = 1;


create table cliente (`id` int auto_increment,`nome` varchar(50), `cpf` varchar(15), nascimento date, primary key (`id`) );

-- drop table unidade;