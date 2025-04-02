package JDBC;

import java.util.List;

public interface AnsattCRUD {
	//Oppretter ny Ansatt rad.
	void lagreAnsatt(Ansatt a);
	
	/** Read1 - Hente ut data fra databasen. En enkelt. */
	Ansatt hentAnsatt(int id);
	
	//Henter ut data fra databasen. En enkelt
	Ansatt hentAnsatt(String id);
	
	//Henter ut data fra databasen. Alle.
	List<Ansatt> hentAlleAnsatt();
	
	/** Read3 - Hente ut data fra databasen. Named Query. */
	List<Ansatt> hentAlleAnsattNQ();
	
	/** Update1 - Oppdatere en person-rad i databasen. */
	void oppdaterAnsatt(Ansatt p);
	
	/** Update2 - Oppdatere en person-rad i databasen. */
	void oppdaterAnsatt(int id, String nyttNavn);
	
	/** Delete - Slette en person-rad fra databasen. */
	void slettAnsatt(int id);
	
	String søkID();
	
	String søkBr();
	
	
}
