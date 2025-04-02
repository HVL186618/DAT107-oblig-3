create Schema SchemaAvdeling;
set search_path to SchemaAvdeling;
CREATE TABLE Avdeling
(
    avdelingID varchar(40) primary key,
    navn varchar(30),
    sjefID varchar(40) references Ansatt (ansattID), --Burde hente ID til personen som er sjef og bør være foreign key
);
