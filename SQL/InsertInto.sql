INSERT INTO SchemaAnsatt.Ansatt (brukernavn, fornavn, etternavn, dato, stilling, månedslønn, avdeling, prosjekter)
VALUES ('Br1', 'Ola', 'Nordmann', DEFAULT, 'ansatt', '1000 kr', null, 'prosjekt 1'),
('Br2','Kari', 'Nordmann', DEFAULT, 'ansatt', '1000 kr', null, 'prosjekt 1');

INSERT INTO SchemaAnsatt.Avdeling (navn, sjefID)
values ('Avdeling 1', '4');