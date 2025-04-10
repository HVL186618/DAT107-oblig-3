create Schema SchemaProsjekt;
set search_path to SchemaProsjekt;
CREATE TABLE Prosjekt
(
    prosjektID varchar(40) primary key,
    navn varchar(30),
    beskrivelse varchar(50)
);