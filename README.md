# DAT107-oblig-3
DAT107 oblig 3

fredag 21. mars 2025
09:38

Ansatt
	• ID (Primærnøkkel/PK)
		○ varchar
	• Brukernavn
		○ varchar
	• Fornavn
		○ varchar
	• Etternavn
		○ varchar
	• Dato
		○ timestamp
	• Stilling
		○ varchar
	• Månedslønn
		○ varchar
	• Avdeling
		○ varchar
	• Prosjekter
		○ varchar

Avdeling
	• avdelingID (Primærnøkkel/PK?)
		○ varchar
	• Navn 
		○ varchar
	• SjefNavn
		○ varchar

Prosjekt
	• ProsjektID (Primærnøkkel/PK?)
		○ varchar
	• Navn
		○ varchar
	• Beskrivelse
		○ varchar

AnsattProsjektTabell (Link tabell)
		○ ansattID (foreign key)
			§ varchar
		○ prosjektID (foreign key)
			§ varchar
		○ rolle
			§ varchar
		○ Arbeidstid
			§ varchar

Ansatt tilhører prosjekt som tilhører avdeling?
Eller, både prosjekt og Avdeling tilhører ansatt?
Prosjekttabell tilhører både Ansatt og Prosjekt.![image](https://github.com/user-attachments/assets/8b7db146-74f8-45ec-ab5b-aedc09bbebc0)
