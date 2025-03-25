create Schema SchemaAvdeling;
set search_path to SchemaAvdeling;
CREATE TABLE Avdeling
(
    avdelingID varchar(40) primary key,
    navn varchar(30),
    sjefnavn varchar(35)
);
