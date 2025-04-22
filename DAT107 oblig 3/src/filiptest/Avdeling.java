package filiptest;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Avdeling {
	@Id
	private int avdelingid;
	private String navn;
	private String sjefnavn;
	
	public int getAvdelingid() {
		return avdelingid;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public String getSjefnavn() {
		return sjefnavn;
	}
	
	public void setId(int i) {
		avdelingid=i;
	}
	
	public void setNavn(String i) {
		navn=i;
	}
	
	public void setSjefnavn(String i) {
		sjefnavn=i;
	}
}