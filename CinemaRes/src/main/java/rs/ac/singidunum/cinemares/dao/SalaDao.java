package rs.ac.singidunum.cinemares.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import rs.ac.singidunum.cinemares.data.Sala;


public class SalaDao {


    private static SalaDao instance = new SalaDao();

    public SalaDao() {
    }
    
    public static SalaDao getInstance(){
        
        return instance;
    }
    
    public List<Sala> findAll(EntityManager em){
        TypedQuery<Sala> query = em.createQuery("SELECT c FROM Sala c", Sala.class);
        return query.getResultList();
    }
    
    public void add(EntityManager em, Sala sala) {
        em.persist(sala);
    }

    public void edit(EntityManager em, Sala sala) {
        em.merge(sala);
    }

    public void delete(EntityManager em, Sala sala) {
        
        Sala managedSala = em.merge(sala);
        em.remove(managedSala);
    }
    
}
