package rs.ac.singidunum.cinemares.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import rs.ac.singidunum.cinemares.data.Bioskop;


public class BioskopDao {


    private static BioskopDao instance = new BioskopDao();

    public BioskopDao() {
    }
    
    public static BioskopDao getInstance(){
        
        return instance;
    }
    
    public List<Bioskop> findAll(EntityManager em){
        TypedQuery<Bioskop> query = em.createQuery("SELECT c FROM Bioskop c", Bioskop.class);
        return query.getResultList();
    }
    
    public void add(EntityManager em, Bioskop bioskop) {
        em.persist(bioskop);
    }

    public void edit(EntityManager em, Bioskop bioskop) {
        em.merge(bioskop);
    }

    public void delete(EntityManager em, Bioskop bioskop) {
        
        Bioskop managedBioskop = em.merge(bioskop);
        em.remove(managedBioskop);
    }
    
}
