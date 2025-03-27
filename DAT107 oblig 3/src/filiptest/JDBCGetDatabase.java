package filiptest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class JDBCGetDatabase {
	
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
		while (active != 0) {
			int valg = Integer.parseInt(JOptionPane.showInputDialog("Lukk Meny (0)\nSøke etter ansatt på ansattID(1)\nSøke etter ansatt på Brukernavn (2)\nUtliste alle Ansatte (3)\nOppdater Ansatt Stiling/Lønn (4)\nLegg til ny Ansatt (5)\nInput valg:"));
			if (valg == 0) {
				active = 0;
				System.out.println(">Stenger meny...");
			}
			else if (valg == 1 ) {
				sokAnsattID(); 
				
			}
			else if (valg == 2 ) {
				
				sokAnsattBruker(); //TODO: Fiks sokAnsattBruker()
				
			}
			else if (valg == 3 ) {
				getAnsattTabell();
				
			}
			else if (valg == 4 ) {
				oppdaterAnsatt();
				
			}
			else if (valg == 5 ) {
				leggTilAnsatt(); //TODO: Fiks leggTilAnsatt()
				
			}
			else {
				System.out.println(">ERROR: Ugyldig valg");
			}
		}
	}
	public static void sokAnsattID() throws ClassNotFoundException {
	 	try {
	 		String sokID = JOptionPane.showInputDialog("Sett inn ID du vil søke for:");
	 		String SQL = "SELECT * FROM SchemaAnsatt.Ansatt where ansattID = '" + sokID + "'"; //FORMAT: SELECT * from 'navn på schema som tilhører tabell'.'navn på tabell'
			conn = DriverManager.getConnection(DB_URL, Brukernavn, Passord);
			//System.out.println(DriverManager.getConnection(DB_URL, Brukernavn, Passord));
			stmnt = conn.createStatement();
			ResultSet rs = (stmnt).executeQuery(SQL);
			try {
			    Class.forName(JDBC_Driver);
			    conn = DriverManager.getConnection(DB_URL, Brukernavn, Passord);

			    java.sql.Statement stmt = conn.createStatement();
			    rs = stmnt.executeQuery(SQL);

			    System.out.println("Result:");
			    while (rs.next()) {
			        String id = rs.getString("ansattID");
			        String brukernavn = rs.getString("brukernavn");
			        String fornavn = rs.getString("fornavn");
			        String etternavn = rs.getString("etternavn");
			        String dato = rs.getString("dato");
			        String stilling = rs.getString("stilling");
			        String lonn = rs.getString("månedslønn");
			        String avdeling = rs.getString("avdeling");
			        String prosjekter = rs.getString("prosjekter");
			        System.out.println("[ansattID: " + id + ", brukernavn: " + brukernavn + ", Fornavn: " + fornavn + ", Etternavn: "  + etternavn + ", Dato: " + dato + ", Stilling: " + stilling  + ", Månedslønn: " + lonn + ", Avdeling: " + avdeling + ", Prosjekter:" + prosjekter + "]");
			    }

			    rs.close();
			    stmt.close();
			    conn.close();
			    stmt.close();
			}
		 	finally {
		 		System.out.println("");
		 	}

		} 
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	finally {
	 		System.out.println("");
	 	}
	}
	public static void getAnsattTabell() throws ClassNotFoundException { //"It just works!" - Todd Howard
	 	try {
	 		String SQL = "SELECT * FROM SchemaAnsatt.Ansatt;";
			conn = DriverManager.getConnection(DB_URL, Brukernavn, Passord);
			//System.out.println(DriverManager.getConnection(DB_URL, Brukernavn, Passord));
			stmnt = conn.createStatement();
			ResultSet rs = (stmnt).executeQuery(SQL);
			try {
			    Class.forName(JDBC_Driver);
			    conn = DriverManager.getConnection(DB_URL, Brukernavn, Passord);

			    java.sql.Statement stmt = conn.createStatement();
			    rs = stmnt.executeQuery(SQL);

			    System.out.println("Result:");
			    while (rs.next()) {
			        String id = rs.getString("ansattID");
			        String brukernavn = rs.getString("brukernavn");
			        String fornavn = rs.getString("fornavn");
			        String etternavn = rs.getString("etternavn");
			        String dato = rs.getString("dato");
			        String stilling = rs.getString("stilling");
			        String lonn = rs.getString("månedslønn");
			        String avdeling = rs.getString("avdeling");
			        String prosjekter = rs.getString("prosjekter");
			        System.out.println("[ansattID: " + id + ", brukernavn: " + brukernavn + ", Fornavn: " + fornavn + ", Etternavn: "  + etternavn + ", Dato: " + dato + ", Stilling: " + stilling  + ", Månedslønn: " + lonn + ", Avdeling: " + avdeling + ", Prosjekter:" + prosjekter + "]");
			    }

			    rs.close();
			    stmt.close();
			    conn.close();
			    stmt.close();
			}
		 	finally {
		 		System.out.println("");
		 	}

		} 
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	finally {
	 		System.out.println("");
	 	}
	}
	public static void sokAnsattBruker() throws ClassNotFoundException {
	 	try {
	 		String sokIni = JOptionPane.showInputDialog("Sett inn initialer du vil søke for:");
	 		String SQL = "SELECT * FROM SchemaAnsatt.Ansatt WHERE brukernavn CONTAINS '" + sokIni + "'";
			conn = DriverManager.getConnection(DB_URL, Brukernavn, Passord);
			//System.out.println(DriverManager.getConnection(DB_URL, Brukernavn, Passord));
			stmnt = conn.createStatement();
			ResultSet rs = (stmnt).executeQuery(SQL);
			try {
			    Class.forName(JDBC_Driver);
			    conn = DriverManager.getConnection(DB_URL, Brukernavn, Passord);

			    java.sql.Statement stmt = conn.createStatement();
			    rs = stmnt.executeQuery(SQL);

			    System.out.println("Result:");
			    while (rs.next()) {
			        String id = rs.getString("ansattID");
			        String brukernavn = rs.getString("brukernavn");
			        String fornavn = rs.getString("fornavn");
			        String etternavn = rs.getString("etternavn");
			        String dato = rs.getString("dato");
			        String stilling = rs.getString("stilling");
			        String lonn = rs.getString("månedslønn");
			        String avdeling = rs.getString("avdeling");
			        String prosjekter = rs.getString("prosjekter");
			        System.out.println("[ansattID: " + id + ", brukernavn: " + brukernavn + ", Fornavn: " + fornavn + ", Etternavn: "  + etternavn + ", Dato: " + dato + ", Stilling: " + stilling  + ", Månedslønn: " + lonn + ", Avdeling: " + avdeling + ", Prosjekter:" + prosjekter + "]");
			    }

			    rs.close();
			    stmt.close();
			    conn.close();
			    stmt.close();
			}
		 	finally {
		 		System.out.println("");
		 	}

		} 
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	finally {
	 		System.out.println("");
	 	}
	}
	public static void leggTilAnsatt() { //Funker ikke.
	 	try {
	 		String idInn = JOptionPane.showInputDialog("Sett inn ID:");
	 		String brukernavnInn = JOptionPane.showInputDialog("Sett inn brukernavn:");
	 		String fornavnInn = JOptionPane.showInputDialog("Sett inn fornavn:");
	 		String etternavnInn = JOptionPane.showInputDialog("Sett inn etternavn:");
	 		String stillingInn = JOptionPane.showInputDialog("Sett inn stilling:");
	 		String lonnInn = JOptionPane.showInputDialog("Sett inn lønn:");
	 		String avdelingInn = JOptionPane.showInputDialog("Sett inn avdeling:");
	 		String prosjektInn = JOptionPane.showInputDialog("Sett inn prosjekt:");
	 		String SQL = "INSERT INTO SchemaAnsatt.Ansatt (ansattID, brukernavn, fornavn, etternavn, dato, stilling, månedslønn, avdeling, prosjekter) VALUES ('" + idInn + "','"+ brukernavnInn + "', '" +fornavnInn + "', '" + etternavnInn + "', DEFAULT, '" + stillingInn + "', '"+ lonnInn + " kr', '" + avdelingInn + "', '"+ prosjektInn + "');"; //FORMAT: SELECT * from 'navn på schema som tilhører tabell'.'navn på tabell'
	 		
			conn = DriverManager.getConnection(DB_URL, Brukernavn, Passord);
			//System.out.println(DriverManager.getConnection(DB_URL, Brukernavn, Passord));
			stmnt = conn.createStatement();
			ResultSet rs = (stmnt).executeQuery(SQL);


		} 
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	finally {
	 		System.out.println("");
	 	}
	}
	public static void oppdaterAnsatt() {
	 	try {
	 		
	 		String idInn = JOptionPane.showInputDialog("Hva er brukerID'en til brukeren du vil endre:");
	 		String valg = JOptionPane.showInputDialog("Hva du vil endre for brukere:");
	 		String omplasser = JOptionPane.showInputDialog("Hva du vil omplassere elementet i " + valg + " med:");
			conn = DriverManager.getConnection(DB_URL, Brukernavn, Passord);
			//System.out.println(DriverManager.getConnection(DB_URL, Brukernavn, Passord));
			String SQL = "UPDATE SchemaAnsatt.Ansatt\r\n"
					+ "SET " +valg+ " = '" + omplasser + "'\r\n"
					+ "WHERE ansattID = " + idInn + ";";
			stmnt = conn.createStatement();
			ResultSet rs = (stmnt).executeQuery(SQL);


		} 
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	finally {
	 		System.out.println("");
	 	}
		
	}

}
