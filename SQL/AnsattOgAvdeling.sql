-- CREATE SCHEMA SchemaAnsatt;
SET search_path TO SchemaAnsatt;

drop table if exists Avdeling;
CREATE TABLE Avdeling (
    avdelingID varchar(40) PRIMARY KEY,
    navn varchar(30),
    sjefID varchar(40) -- placeholder, FK added later
);

drop table if exists Ansatt;
CREATE TABLE Ansatt (
    ansattID varchar(40) PRIMARY KEY,
    brukernavn varchar(4),
    fornavn varchar(30),
    etternavn varchar(20),
    dato timestamp,
    stilling varchar(15),
    månedslønn varchar(30),
    avdelingID varchar(40) REFERENCES Avdeling(avdelingID),
    prosjekter varchar(30)
);

ALTER TABLE Avdeling
ADD CONSTRAINT fk_sjef
FOREIGN KEY (sjefID) REFERENCES Ansatt(ansattID);
