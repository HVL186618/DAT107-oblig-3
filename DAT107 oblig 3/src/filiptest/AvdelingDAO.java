package filiptest;

import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AvdelingDAO {
	private EntityManagerFactory emf;
	
	public AvdelingDAO() {
        emf = Persistence.createEntityManagerFactory("PersonAnsattStudentPU",
				Map.of("jakarta.persistence.jdbc.password", Passwords.password))
        		;
	}
	
	public Avdeling finnAvdelingMedId(String id) {

        EntityManager em = emf.createEntityManager();

        Avdeling avdeling = null;
        try {
            avdeling = em.find(Avdeling.class, id);
        } finally {
            em.close();
        }
        return avdeling;
    }
}
