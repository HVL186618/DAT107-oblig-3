package filiptest;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "avdeling", schema = "schemaavdeling")
public class Avdeling {
	@Id
	private String avdelingid;
	private String navn;
	private String sjefnavn;
	
	public String getAvdelingid() {
		return avdelingid;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public String getSjefnavn() {
		return sjefnavn;
	}
	
	public void setAvdelingid(String i) {
		avdelingid=i;
	}
	
	public void setNavn(String i) {
		navn=i;
	}
	
	public void setSjefnavn(String i) {
		sjefnavn=i;
	}

	@Override
	public String toString() {
		return "Avdeling [avdelingid=" + avdelingid + ", navn=" + navn + ", sjefnavn=" + sjefnavn + "]";
	}
	
}