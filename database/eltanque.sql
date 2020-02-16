create database eltanque;
use eltanque;

#drop database eltanque;
create table cliente
(
	nome varchar(25) not null,
    
    cognome varchar(25) not null,
    
    username varchar(25) primary key not null,
    
    email varchar(25) not null,
	
    passwo varchar(25) not null
);


INSERT INTO `eltanque`.`cliente` (`nome`, `cognome`, `username`, `email`, `passwo`) VALUES ('Felice', 'Coppola', 'felice23', 'Felice1.@gmail.com', 'Felice123');


create table gestore_tavoli
(
	codice_gestore_tavoli varchar(25) primary key not null
);
INSERT INTO `eltanque`.`gestore_tavoli` (`codice_gestore_tavoli`) VALUES ('GT-1');

create table tavolo
(
	num_tavolo int primary key not null,
    
    num_posti int not null
);

INSERT INTO `eltanque`.`tavolo` (`num_tavolo`, `num_posti`) VALUES ('1', '4');
INSERT INTO `eltanque`.`tavolo` (`num_tavolo`, `num_posti`) VALUES ('2', '2');
INSERT INTO `eltanque`.`tavolo` (`num_tavolo`, `num_posti`) VALUES ('3', '4');
INSERT INTO `eltanque`.`tavolo` (`num_tavolo`, `num_posti`) VALUES ('4', '5');
INSERT INTO `eltanque`.`tavolo` (`num_tavolo`, `num_posti`) VALUES ('5', '2');
INSERT INTO `eltanque`.`tavolo` (`num_tavolo`, `num_posti`) VALUES ('6', '1');

create table titolare
(
	codice_titolare varchar(25) primary key not null
);

INSERT INTO `eltanque`.`titolare` (`codice_titolare`) VALUES ('T-1');

create table prenotazione
(
    num_tavolo int not null,
    foreign key(num_tavolo) references tavolo(num_tavolo) on delete cascade on update cascade,
    
    username varchar(25) not null,
    foreign key(username) references cliente(username) on update cascade,

    data date,
    
    ora_inizio time,
    
    ora_fine time,
    
    primary key(num_tavolo,data,ora_fine,ora_inizio)
);

INSERT INTO `eltanque`.`prenotazione` (`num_tavolo`, `username`, `data`, `ora_inizio`, `ora_fine`) VALUES ('1', 'felice23', '2020-01-01', '19:00:00', '20:00:00');
INSERT INTO `eltanque`.`prenotazione` (`num_tavolo`, `username`, `data`, `ora_inizio`, `ora_fine`) VALUES ('1', 'felice23', '2020-01-01', '20:00:00', '21:00:00');


