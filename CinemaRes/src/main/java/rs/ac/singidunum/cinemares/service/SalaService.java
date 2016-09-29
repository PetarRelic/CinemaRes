package rs.ac.singidunum.cinemares.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import rs.ac.singidunum.cinemares.dao.EntityManagerWrapper;
import rs.ac.singidunum.cinemares.dao.SalaDao;
import rs.ac.singidunum.cinemares.data.Sala;
import rs.ac.singidunum.cinemares.exceptions.CinemaResException;

public class SalaService {


    private static final SalaService instance = new SalaService();

    public SalaService() {
    }
    
    
    public static SalaService getInstance(){
        return instance;
    } 
    
    
    public void add(Sala sala) throws CinemaResException {

        validate(sala);

        EntityManager em = EntityManagerWrapper.createEntityManager();
        try {
            em.getTransaction().begin();
            SalaDao.getInstance().add(em, sala);
            em.getTransaction().commit();
        } finally {
            
            em.close();
        }
    }
    
    public void edit(Sala sala) throws CinemaResException{
        
        validate(sala);
        
        EntityManager em= EntityManagerWrapper.createEntityManager();
        
        try{
            em.getTransaction().begin();
            SalaDao.getInstance().edit(em, sala);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    public void delete(Sala sala) throws CinemaResException{
        
        if (sala.getIdSala()== null) {
            throw new CinemaResException("Nepoznat ID sale.");
        }
        
        EntityManager em =  EntityManagerWrapper.createEntityManager();
        
        try{
            em.getTransaction().begin();
            SalaDao.getInstance().delete(em, sala);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    private void validate(Sala sala) throws CinemaResException {
        /*
         Lista u koju cemo smestati validacijske greske.
         Ako bude bilo greski u ovoj listi, na kraju metode ce biti bacen izuzetak koji enkapsulira/sadrzi listu gresaka.
         Ako ne bude bilo validacijskih greski lista ce ostati prazna i izuzetak nece bit  bacen.
         */
        List<String> errors = new ArrayList<>();

        if (sala.getBr_sale()== null) {
            errors.add("Parametar broj sale je obavezan.");
        }

        if (sala.getBr_sedista() == null) {
            errors.add("Parametar broj sedista je obavezan.");
        }


        if (!errors.isEmpty()) {
            throw new CinemaResException(errors);
        }
    }
    
    public List<Sala> findAll() {
        EntityManager em = EntityManagerWrapper.createEntityManager();
        try {
            return SalaDao.getInstance().findAll(em);
        } finally {
            em.close();
        }
    }
    
}
