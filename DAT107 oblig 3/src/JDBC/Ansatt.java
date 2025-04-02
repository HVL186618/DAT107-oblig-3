package JDBC;

import java.sql.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

public class Ansatt {
	
	@Id	private Integer id;
	private String navn;
	
	public Ansatt() {}
	
	public Ansatt(Integer id, String navn) {
		this.id = id;
		this.navn = navn;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	@Override
	public String toString() {
		return String.format("Person: id=%d, navn=%s", id, navn);
	}
    
    public static void main(String[] args) {
    	
    }
}
