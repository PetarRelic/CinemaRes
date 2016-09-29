package rs.ac.singidunum.cinemares.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import rs.ac.singidunum.cinemares.dao.EntityManagerWrapper;
import rs.ac.singidunum.cinemares.dao.ProjekcijaDao;
import rs.ac.singidunum.cinemares.data.Projekcija;
import rs.ac.singidunum.cinemares.exceptions.CinemaResException;

public class ProjekcijaService {


     private static final ProjekcijaService instance = new ProjekcijaService();

    public ProjekcijaService() {
    }
    
    
    public static ProjekcijaService getInstance(){
        return instance;
    } 
    
    
    public void add(Projekcija projekcija) throws CinemaResException {

        validate(projekcija);

        EntityManager em = EntityManagerWrapper.createEntityManager();
        try {
            em.getTransaction().begin();
            ProjekcijaDao.getInstance().add(em, projekcija);
            em.getTransaction().commit();
        } finally {
            
            em.close();
        }
    }
    
    public void edit(Projekcija projekcija) throws CinemaResException{
        
        validate(projekcija);
        
        EntityManager em= EntityManagerWrapper.createEntityManager();
        
        try{
            em.getTransaction().begin();
            ProjekcijaDao.getInstance().edit(em, projekcija);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    public void delete(Projekcija projekcija) throws CinemaResException{
        
        if (projekcija.getIdProjekcija()== null) {
            throw new CinemaResException("Nepoznat ID projekcije.");
        }
        
        EntityManager em =  EntityManagerWrapper.createEntityManager();
        
        try{
            em.getTransaction().begin();
            ProjekcijaDao.getInstance().delete(em, projekcija);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    private void validate(Projekcija projekcija) throws CinemaResException {
        
        List<String> errors = new ArrayList<>();

        if (projekcija.getTermin_projekcije()== null) {
            errors.add("Parametar termin projekcije je obavezan.");
        }


        if (!errors.isEmpty()) {
            throw new CinemaResException(errors);
        }
    }
    
    public List<Projekcija> findAll() {
        EntityManager em = EntityManagerWrapper.createEntityManager();
        try {
            return ProjekcijaDao.getInstance().findAll(em);
        } finally {
            em.close();
        }
    }
    
}
