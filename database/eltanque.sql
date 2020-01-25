create database eltanque;
use eltanque;

create table cliente
(
	nome varchar(25) not null,
    
    cognome varchar(25) not null,
    
    username varchar(25) primary key not null,
	
    passwo varchar(25) not null
);
create table tavolo
(
	num_tavolo int primary key not null,
    
    num_posti int not null,
    
    stato_tavolo bool
);
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