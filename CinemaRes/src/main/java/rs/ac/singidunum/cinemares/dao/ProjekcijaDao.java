package rs.ac.singidunum.cinemares.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import rs.ac.singidunum.cinemares.data.Projekcija;

public class ProjekcijaDao {


    private static ProjekcijaDao instance = new ProjekcijaDao();

    public ProjekcijaDao() {
    }
    
    public static ProjekcijaDao getInstance(){
        
        return instance;
    }
    
    public List<Projekcija> findAll(EntityManager em){
        TypedQuery<Projekcija> query = em.createQuery("SELECT c FROM Projekcija c", Projekcija.class);
        return query.getResultList();
    }
    
    public void add(EntityManager em, Projekcija projekcija) {
        em.persist(projekcija);
    }

    public void edit(EntityManager em, Projekcija projekcija) {
        em.merge(projekcija);
    }

    public void delete(EntityManager em, Projekcija projekcija) {
        
        Projekcija managedProjekcija = em.merge(projekcija);
        em.remove(managedProjekcija);
    }
    
}
