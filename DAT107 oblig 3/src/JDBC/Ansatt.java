package JDBC;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Ansatt {
	public String id;
	public Ansatt(String id) {
		this.id = id;
	}
	public String getId() {
		//TODO
		return id;
		
	}
	
	public void setId(String id) {
		this.id = id;
	}
}
