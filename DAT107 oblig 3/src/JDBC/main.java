package JDBC;

import java.sql.Connection;
<<<<<<< Updated upstream
import JDBC.Ansatt;
import JDBC.AnsattCRUD;
=======

import javax.swing.JOptionPane;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
>>>>>>> Stashed changes

public class main {
	static final String JDBC_Driver = "org.postgresql.Driver";
	static final String Database = "h186618";
	static final String Brukernavn = "h186618";
	static final String Passord = "#HVL_SQL233!"; //legg til "-WITH PASSWORD '#HVL_SQL233!';" inni PGAdmin for å få tilgang med dette passordet.
	
	static final String Tjener_og_port = "ider-database.westeurope.cloudapp.azure.com:5433"; //Måtte legge til PSQL port for at dette skulle fungere. Enten 5433 eller 5432
	static final String DB_URL = "jdbc:postgresql://" + Tjener_og_port + "/" + Database;
	public static int active = 1;
	public static Connection conn;
	public static java.sql.Statement stmnt;
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String SQL = "SELECT * FROM SchemaAnsatt.Ansatt"; //FORMAT: SELECT * from 'navn på schema som tilhører tabell'.'navn på tabell'
		
		conn = null;
		stmnt = null;
		Class.forName(JDBC_Driver);
		System.out.println(">Kobler til database...");
		System.out.println(">...");
		String inn;
		Ansatt.hentAnsatt(inn);

<<<<<<< Updated upstream
	}
=======
        Ansatt a = em.find(Ansatt.class, "NO 1");
        System.out.println(a.getFornavn());

        em.getTransaction().begin();
        a.setFornavn("Ola");
        em.getTransaction().commit();
        
        System.out.println(a);
        
        // search query
        TypedQuery<Ansatt> q = em.createQuery(
        	    "SELECT a FROM Ansatt a WHERE a.brukernavn = :brukernavn", Ansatt.class);
    	q.setParameter("brukernavn", "Br2");

    	Ansatt b = q.getSingleResult();
    	System.out.println(b);
        
    	String idInput = JOptionPane.showInputDialog("Hva ID vil du søke for?");
    	Ansatt c = em.find(Ansatt.class, idInput);
    	System.out.println(c);
        em.close();
        emf.close();
    }
>>>>>>> Stashed changes

}
