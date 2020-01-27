create database eltanque;
use eltanque;

create table cliente
(
	nome varchar(25) not null,
    
    cognome varchar(25) not null,
    
    username varchar(25) primary key not null,
    
    email varchar(25) not null,
	
    passwo varchar(25) not null
);
create table tavolo
(
	num_tavolo int primary key not null,
    
    num_posti int not null,
    
    stato_tavolo bool
);
INSERT INTO `eltanque`.`tavolo` (`num_tavolo`, `num_posti`, `stato_tavolo`) VALUES ('1', '2', false);
INSERT INTO `eltanque`.`tavolo` (`num_tavolo`, `num_posti`, `stato_tavolo`) VALUES ('2', '2', false);
INSERT INTO `eltanque`.`tavolo` (`num_tavolo`, `num_posti`, `stato_tavolo`) VALUES ('3', '3', false);
INSERT INTO `eltanque`.`tavolo` (`num_tavolo`, `num_posti`, `stato_tavolo`) VALUES ('4', '5', false);

create table gestore_tavoli
(
	codice_gestore_tavoli int primary key not null
);
create table titolare
(
	codice_titolare int primary key not null
);
create table prenotazione
(
    num_tavolo int not null,
    foreign key(num_tavolo) references tavolo(num_tavolo),
    
    username varchar(25) not null,
    foreign key(username) references cliente(username),
    
    data date,
    
    ora_inizio time,
    
    ora_fine time,
    
    primary key(num_tavolo,data,ora_fine,ora_inizio)
);
select c.nome from cliente c,prenotazione p where c.username = p.username group by c.nome order by count(*) desc ;
INSERT INTO `eltanque`.`gestore_tavoli` (`codice_gestore_tavoli`) VALUES ('1000');
INSERT INTO `eltanque`.`gestore_tavoli` (`codice_gestore_tavoli`) VALUES ('1001');
INSERT INTO `eltanque`.`titolare` (`codice_titolare`) VALUES (0001);


