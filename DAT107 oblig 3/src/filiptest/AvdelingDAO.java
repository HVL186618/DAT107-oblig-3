package filiptest;

import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AvdelingDAO {
	private EntityManagerFactory emf;
	
	public AvdelingDAO() {
        emf = Persistence.createEntityManagerFactory("avdelingPU",
				Map.of("jakarta.persistence.jdbc.password", Passwords.password))
        		;
	}
	
	public Avdeling finnAvdelingMedId(String avdelingid) {

        EntityManager em = emf.createEntityManager();

        Avdeling avdeling = null;
        try {
            avdeling = em.find(Avdeling.class, avdelingid);
        } finally {
            em.close();
        }
        return avdeling;
    }
}
