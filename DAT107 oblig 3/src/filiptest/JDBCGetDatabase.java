package filiptest;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCGetDatabase {
	static final String JDBC_Driver = "org.postgresql.Driver";
	static final String Database = "h186618";
	static final String Brukernavn = "h186618";
	static final String Passord = "#HVL_SQL233!"; //legg til "-WITH PASSWORD '#HVL_SQL233!';" inni PGAdmin for å få tilgang med dette passordet.
	
	static final String Tjener_og_port = "ider-database.westeurope.cloudapp.azure.com:5433"; //Måtte legge til PSQL port for at dette skulle fungere. Enten 5433 eller 5432
	static final String DB_URL = "jdbc:postgresql://" + Tjener_og_port + "/" + Database;

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String SQL = "SELECT * FROM SchemaAnsatt.Ansatt"; //FORMAT: SELECT * from 'navn på schema som tilhører tabell'.'navn på tabell'
		
		Connection conn = null;
		java.sql.Statement stmnt = null;
		Class.forName(JDBC_Driver);
		System.out.println("Kobler til database...");
	 	try {
			conn = DriverManager.getConnection(DB_URL, Brukernavn, Passord);
			System.out.println(DriverManager.getConnection(DB_URL, Brukernavn, Passord));
			stmnt = conn.createStatement();
			ResultSet rs = (stmnt).executeQuery(SQL);
			try {
			    Class.forName(JDBC_Driver);

			    System.out.println("Connecting to database...");
			    conn = DriverManager.getConnection(DB_URL, Brukernavn, Passord);

			    java.sql.Statement stmt = conn.createStatement();
			    rs = stmnt.executeQuery(SQL);

			    System.out.println("Result:");
			    while (rs.next()) {
			        String id = rs.getString("ansattID");
			        String navn = rs.getString("brukernavn");

			        System.out.print("\tansattID: " + id);
			        System.out.println(", brukernavn: " + navn);
			    }

			    rs.close();
			    stmt.close();
			    conn.close();
			    stmt.close();
			}
		 	finally {
		 		System.out.println("Ferdig.");
		 	}

		} 
	 	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	finally {
	 		System.out.println("Ferdig.");
	 	}
	 	

	}

}
