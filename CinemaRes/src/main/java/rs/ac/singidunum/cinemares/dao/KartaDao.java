package rs.ac.singidunum.cinemares.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import rs.ac.singidunum.cinemares.data.Karta;


public class KartaDao {


    private static KartaDao instance = new KartaDao();

    public KartaDao() {
    }
    
    public static KartaDao getInstance(){
        
        return instance;
    }
    public List<Karta> findAll(EntityManager em){
        TypedQuery<Karta> query = em.createQuery("SELECT c FROM Karta c", Karta.class);
        return query.getResultList();
    }
    
    public void add(EntityManager em, Karta karta) {
        em.persist(karta);
    }

    public void edit(EntityManager em, Karta karta) {
        em.merge(karta);
    }

    public void delete(EntityManager em, Karta karta) {
        
        Karta managedKarta = em.merge(karta);
        em.remove(managedKarta);
    }
    
}
