package filiptest;

import java.util.Map;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AvdelingDAO {
	private EntityManagerFactory emf;
	
	public AvdelingDAO() {
        emf = Persistence.createEntityManagerFactory("PersonAnsattStudentPU",
				Map.of("jakarta.persistence.jdbc.password", Passwords.password))
        		;
	}
}
