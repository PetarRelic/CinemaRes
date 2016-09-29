package rs.ac.singidunum.cinemares.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import rs.ac.singidunum.cinemares.dao.EntityManagerWrapper;
import rs.ac.singidunum.cinemares.dao.KorisnikDao;
import rs.ac.singidunum.cinemares.data.Korisnik;
import rs.ac.singidunum.cinemares.exceptions.CinemaResException;

public class KorisnikService {


    private static final KorisnikService instance = new KorisnikService();

    public KorisnikService() {
    }
    
    
    public static KorisnikService getInstance(){
        return instance;
    } 
    
    public boolean checkLogin(Korisnik korisnik) throws CinemaResException{
        
        EntityManager em = EntityManagerWrapper.createEntityManager();
        
        try{
            return KorisnikDao.getInstance().checkLogin(em,korisnik);
        }finally{
            em.close();
        }
    }
    
    public void add(Korisnik korisnik) throws CinemaResException {

        validate(korisnik);

        EntityManager em = EntityManagerWrapper.createEntityManager();
        try {
            em.getTransaction().begin();
            KorisnikDao.getInstance().add(em, korisnik);
            em.getTransaction().commit();
        } finally {
            
            em.close();
        }
    }
    
    public void edit(Korisnik korisnik) throws CinemaResException{
        
        validate(korisnik);
        
        EntityManager em= EntityManagerWrapper.createEntityManager();
        
        try{
            em.getTransaction().begin();
            KorisnikDao.getInstance().edit(em, korisnik);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    public void delete(Korisnik korisnik) throws CinemaResException{
        
        if (korisnik.getIdKorisnik()== null) {
            throw new CinemaResException("Nepoznat ID korisnika.");
        }
        
        EntityManager em =  EntityManagerWrapper.createEntityManager();
        
        try{
            em.getTransaction().begin();
            KorisnikDao.getInstance().delete(em, korisnik);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    private void validate(Korisnik korisnik) throws CinemaResException {
        /*
         Lista u koju cemo smestati validacijske greske.
         Ako bude bilo greski u ovoj listi, na kraju metode ce biti bacen izuzetak koji enkapsulira/sadrzi listu gresaka.
         Ako ne bude bilo validacijskih greski lista ce ostati prazna i izuzetak nece bit  bacen.
         */
        List<String> errors = new ArrayList<>();

        if (korisnik.getKorisnicko_ime()== null || korisnik.getKorisnicko_ime().trim().isEmpty()) {
            errors.add("Parametar korisnicko ime je obavezan.");
        } else if (korisnik.getKorisnicko_ime().length() > 45) {
            errors.add("Parametar korisnicko ime ne sme biti duzi od 45 karaktera");
        }

        if (korisnik.getLozinka() == null || korisnik.getLozinka().trim().isEmpty()) {
            errors.add("Parametar lozinka je obavezan.");
        } else if (korisnik.getLozinka().length() > 45) {
            errors.add("Parametar lozinka ne sme biti duzi od 45 karaktera");
        }

        if (korisnik.getEmail()!= null && korisnik.getEmail().length() > 45) {
            errors.add("Parametar email ne sme biti duzi od 45 karaktera");
        }


        if (!errors.isEmpty()) {
            throw new CinemaResException(errors);
        }
    }
    
    public List<Korisnik> findAll() {
        EntityManager em = EntityManagerWrapper.createEntityManager();
        try {
            return KorisnikDao.getInstance().findAll(em);
        } finally {
            em.close();
        }
    }
}
