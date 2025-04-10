-- CREATE SCHEMA SchemaAnsatt;
SET search_path TO SchemaAnsatt;

drop table if exists Avdeling cascade; --Cascade gjør at det sletter alle tabeller som er avhengi på denne.
CREATE TABLE Avdeling (
    avdelingID SERIAL PRIMARY KEY,
    navn varchar(30),
    sjefID SERIAL -- placeholder, FK added later
);

drop table if exists Ansatt;
CREATE TABLE Ansatt (
    ansattID SERIAL PRIMARY KEY,
    brukernavn varchar(4),
    fornavn varchar(30),
    etternavn varchar(20),
    dato timestamp,
    stilling varchar(15),
    månedslønn varchar(30),
    avdelingID SERIAL REFERENCES Avdeling(avdelingID),
    prosjekter varchar(30)
);

ALTER TABLE Avdeling
ADD CONSTRAINT fk_sjef
FOREIGN KEY (sjefID) REFERENCES Ansatt(ansattID);
