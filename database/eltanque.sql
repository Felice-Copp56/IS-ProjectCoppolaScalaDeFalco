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
create table gestore_tavoli
(
	codice_gestore_tavoli varchar(25) primary key not null
);
create table tavolo
(
	num_tavolo int primary key not null,
    
    num_posti int not null,
    
    stato_tavolo bool
);

create table titolare
(
	codice_titolare varchar(25) primary key not null
);
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
select p.num_tavolo,p.username,p.data,p.ora_inizio,p.ora_fine from prenotazione p where p.data between "2020-01-01" and "2020-03-01";




