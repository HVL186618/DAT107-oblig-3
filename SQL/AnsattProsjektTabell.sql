create Schema SchemaAPT;
set search_path to SchemaAPT;
CREATE TABLE AnsattProsjektTabell
(
    ansattID varchar(40) references Ansatt (ID),
    prosjektID varchar(40) references Prosjekt (prosjektID),
    rolle varchar(15),
    arbeidstid varchar(30)
);