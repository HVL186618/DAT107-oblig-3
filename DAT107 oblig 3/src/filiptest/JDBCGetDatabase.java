package filiptest;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
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
		String SQL = ""; //Fyll inn.
		
		Connection conn = null;
		Statement stmnt = null;
		Class.forName(JDBC_Driver);
	 	try {
			DriverManager.getConnection(DB_URL, Brukernavn, Passord);
			System.out.println(DriverManager.getConnection(DB_URL, Brukernavn, Passord));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
