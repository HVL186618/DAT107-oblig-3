package JDBC;

import java.util.List;

public interface AnsattCRUD {
	//Oppretter ny Ansatt rad.
	void lagreAnsatt(Ansatt a);
	
	//Henter ut data fra databasen. En enkelt
	Ansatt hentAnsatt(String id);
	
	//Henter ut data fra databasen. Alle.
	List<Ansatt> hentAlleAnsatt();
	
	
	
	
}
