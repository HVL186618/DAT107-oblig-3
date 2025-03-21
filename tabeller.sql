CREATE TABLE Ansatt
(
    ansattID varchar(40) primary key,
    brukernavn varchar(4),
    fornavn varchar(30),
    etternavn varchar(20),
    dato timestamp,
    stilling varchar(15),
    månedslønn varchar(30),
    avdeling varchar(30),
    prosjekter varchar(30)
);
INSERT INTO Ansatt (ansattID, brukernavn, fornavn, etternavn, dato, stilling, månedslønn, avdeling, prosjekter)
VALUES ('NO 1','Br1', 'Ola', 'Nordmann', DEFAULT, 'ansatt', '1000 kr', 'avdeling 1', 'prosjekt 1'),
('NO 2','Br2','Kari', 'Nordmann', DEFAULT, 'ansatt', '1000 kr', 'avdeling 1', 'prosjekt 1');

CREATE TABLE Avdeling
(
    avdelingID varchar(40) primary key,
    navn varchar(30),
    sjefnavn varchar(35)
);

CREATE TABLE Prosjekt
(
    prosjektID varchar(40) primary key,
    navn varchar(30),
    beskrivelse varchar(50)
);

CREATE TABLE AnsattProsjektTabell
(
    ansattID varchar(40) references Ansatt (ID),
    prosjektID varchar(40) references Prosjekt (prosjektID),
    rolle varchar(15),
    arbeidstid varchar(30)
);
