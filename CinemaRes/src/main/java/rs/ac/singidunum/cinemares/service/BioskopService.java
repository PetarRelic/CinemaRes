package rs.ac.singidunum.cinemares.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import rs.ac.singidunum.cinemares.dao.BioskopDao;
import rs.ac.singidunum.cinemares.dao.EntityManagerWrapper;
import rs.ac.singidunum.cinemares.data.Bioskop;
import rs.ac.singidunum.cinemares.exceptions.CinemaResException;

public class BioskopService {
    
    private static final BioskopService instance = new BioskopService();

    public BioskopService() {
    }

    public static BioskopService getInstance(){
        return instance;
    } 
    
    public void add(Bioskop bioskop) throws CinemaResException{
        
        validate(bioskop);
        
        EntityManager em = EntityManagerWrapper.createEntityManager();
        try{
            em.getTransaction().begin();
            BioskopDao.getInstance().add(em, bioskop);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    public void edit(Bioskop bioskop) throws CinemaResException{
        
        validate(bioskop);
        
        EntityManager em = EntityManagerWrapper.createEntityManager();
        try{
            em.getTransaction().begin();
            BioskopDao.getInstance().edit(em, bioskop);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    public void delete(Bioskop bioskop) throws CinemaResException{
        
        if (bioskop.getIdBioskop()== null) {
            throw new CinemaResException("Nepoznat ID bioskop.");
        }
        
        EntityManager em = EntityManagerWrapper.createEntityManager();
        try{
            em.getTransaction().begin();
            BioskopDao.getInstance().delete(em, bioskop);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    

    private void validate(Bioskop bioskop) throws CinemaResException {
        /*
         Lista u koju cemo smestati validacijske greske.
         Ako bude bilo greski u ovoj listi, na kraju metode ce biti bacen izuzetak koji enkapsulira/sadrzi listu gresaka.
         Ako ne bude bilo validacijskih greski lista ce ostati prazna i izuzetak nece bit  bacen.
         */
        List<String> errors = new ArrayList<>();

        if (bioskop.getNaziv()== null || bioskop.getNaziv().trim().isEmpty()) {
            errors.add("Parametar naziv je obavezan.");
        } else if (bioskop.getNaziv().length() > 45) {
            errors.add("Parametar naziv ne sme biti duzi od 45 karaktera");
        }

        if (bioskop.getAdresa() == null || bioskop.getAdresa().trim().isEmpty()) {
            errors.add("Parametar adresa je obavezan.");
        } else if (bioskop.getAdresa().length() > 45) {
            errors.add("Parametar adresa ne sme biti duzi od 45 karaktera");
        }


        if (!errors.isEmpty()) {
            throw new CinemaResException(errors);
        }
    }
    
    
    public List<Bioskop> findAll() {
        EntityManager em = EntityManagerWrapper.createEntityManager();
        try {
            return BioskopDao.getInstance().findAll(em);
        } finally {
            em.close();
        }
    }
    
}
