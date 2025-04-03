package JDBC;

import java.sql.Connection;

import javax.swing.JOptionPane;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class main {
	static final String JDBC_Driver = "org.postgresql.Driver";
	static final String Database = "h186618";
	static final String Brukernavn = "h186618";
	static final String Passord = "#HVL_SQL233!"; //legg til "-WITH PASSWORD '#HVL_SQL233!';" inni PGAdmin for å få tilgang med dette passordet.
	
	static final String Tjener_og_port = "ider-database.westeurope.cloudapp.azure.com:5433"; //Måtte legge til PSQL port for at dette skulle fungere. Enten 5433 eller 5432
	static final String DB_URL = "jdbc:postgresql://" + Tjener_og_port + "/" + Database;
	public static String elementValg;
	public static int active = 1;
	public static Connection conn;
	public static java.sql.Statement stmnt;
	
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ansattPU");
        EntityManager em = emf.createEntityManager();

        //Ansatt a = em.find(Ansatt.class, "NO 1");
        //System.out.println(a.getFornavn());

        //em.getTransaction().begin();
        //a.setFornavn("Ola");
        //em.getTransaction().commit();
        
        //System.out.println(a);
        
        // search query
        //TypedQuery<Ansatt> q = em.createQuery("SELECT a FROM Ansatt a WHERE a.brukernavn = :brukernavn", Ansatt.class); // :tekst er brukt til variable substitution
    	//q.setParameter("brukernavn", "Br2");

    	//Ansatt b = q.getSingleResult();
    	//System.out.println(b);
        //em.close();
        //emf.close();
        

		while (active != 0) {
			int valg = Integer.parseInt(JOptionPane.showInputDialog("Lukk Meny (0)\nSøke etter ansatt på ansattID(1)\nSøke etter ansatt på Brukernavn (2)\nUtliste alle Ansatte (3)\nOppdater Ansatt Stiling/Lønn (4)\nLegg til ny Ansatt (5)\nInput valg:"));
			if (valg == 0) {
				active = 0;
				System.out.println(">Stenger meny...");
			}
			else if (valg == 1 ) {
		    	String idInput = JOptionPane.showInputDialog("Hva ID vil du søke for?");
		    	Ansatt valg1= em.find(Ansatt.class, idInput);
		    	System.out.println(valg1);
				
			}
			else if (valg == 2 ) {
				//TODO - finn ut hvordan man får hele tabellen listet ut.
				Ansatt valg2 = em.find(Ansatt.class, "*"); //Funker ikke. Hvordan får man alle?
				System.out.println(Ansatt.class);
				
			}
			else if (valg == 3 ) {
				TypedQuery<Ansatt> alleAnsatte = em.createQuery("SELECT a FROM Ansatt a", Ansatt.class);
				for (Ansatt ansatt : alleAnsatte.getResultList()) {
				    System.out.println(ansatt);
				}

			}
			else if (valg == 4 ) {
				//TODO - fiks koden.
				String idInput = JOptionPane.showInputDialog("Hva ID vil du søke for?");
				int gyldigValg = 0;
				elementValg = JOptionPane.showInputDialog("Valg: stilling, månedslønn\nHva du vil endre for brukeren?:");
				/*
				while (gyldigValg == 0) {
					elementValg = JOptionPane.showInputDialog("\nValg: stilling, månedslønn\nHva du vil endre for brukeren?:");

					if (elementValg != "stilling" || elementValg != "månedslønn")  {
						System.out.println(">Ugyldig valg!");
					}
					else {
						gyldigValg = 1;
					}
				}
				*/
				String endreValg = JOptionPane.showInputDialog("Hva skal verdien i '" + elementValg + "' endres til?:");

				Ansatt valg4 = em.find(Ansatt.class, idInput);
				
				em.getTransaction().begin();
				if (elementValg == "stilling") valg4.setStilling(endreValg);
				else if (elementValg == "månedslønn") valg4.setMånedslønn(endreValg);
		    	em.getTransaction().commit();
		    	
		        //TypedQuery<Ansatt> query = em.createQuery("SELECT valg4 FROM Ansatt valg4 WHERE valg4."  + elementValg + " = :" + elementValg + "", Ansatt.class); //: betyr at man skal endre brukernavn til noe annet.
		    	//query.setParameter(elementValg, endreValg); //Klarer ikke å endre element etter valg. Vet ikke hvorfor.
			}
			else if (valg == 5 ) {
				//TODO
				
			}
			else {
				System.out.println(">ERROR: Ugyldig valg");
			}
		}
        em.close();
        emf.close();
    }

}
