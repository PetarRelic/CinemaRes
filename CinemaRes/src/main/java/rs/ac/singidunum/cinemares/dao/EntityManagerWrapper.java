package rs.ac.singidunum.cinemares.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerWrapper {


    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CinemaResPU");
    
    
    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }
}
