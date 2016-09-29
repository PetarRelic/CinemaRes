package rs.ac.singidunum.cinemares.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import rs.ac.singidunum.cinemares.dao.EntityManagerWrapper;
import rs.ac.singidunum.cinemares.dao.FilmDao;
import rs.ac.singidunum.cinemares.data.Film;
import rs.ac.singidunum.cinemares.exceptions.CinemaResException;

public class FilmService {

    private static final FilmService instance = new FilmService();

    public FilmService() {
    }

    public static FilmService getInstance(){
        return instance;
    } 
    
    public void add(Film film) throws CinemaResException{
        
        validate(film);
        
        EntityManager em = EntityManagerWrapper.createEntityManager();
        try{
            em.getTransaction().begin();
            FilmDao.getInstance().add(em, film);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    public void edit(Film film) throws CinemaResException{
        
        validate(film);
        
        EntityManager em = EntityManagerWrapper.createEntityManager();
        try{
            em.getTransaction().begin();
            FilmDao.getInstance().edit(em, film);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    public void delete(Film film) throws CinemaResException{
        
        if (film.getIdFilm()== null) {
            throw new CinemaResException("Nepoznat ID filma.");
        }
        
        EntityManager em = EntityManagerWrapper.createEntityManager();
        try{
            em.getTransaction().begin();
            FilmDao.getInstance().delete(em, film);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    private void validate(Film film) throws CinemaResException {
        /*
         Lista u koju cemo smestati validacijske greske.
         Ako bude bilo greski u ovoj listi, na kraju metode ce biti bacen izuzetak koji enkapsulira/sadrzi listu gresaka.
         Ako ne bude bilo validacijskih greski lista ce ostati prazna i izuzetak nece bit  bacen.
         */
        List<String> errors = new ArrayList<>();

        if (film.getNaziv() == null || film.getNaziv().trim().isEmpty()) {
            errors.add("Parametar naziv je obavezan.");
        } else if (film.getNaziv().length() > 45) {
            errors.add("Parametar naziv ne sme biti duzi od 45 karaktera");
        }

        if (film.getZanr() == null || film.getZanr().trim().isEmpty()) {
            errors.add("Parametar zanr je obavezan.");
        } else if (film.getZanr().length() > 45) {
            errors.add("Parametar zanr ne sme biti duzi od 45 karaktera");
        }


        if (!errors.isEmpty()) {
            throw new CinemaResException(errors);
        }
    }
    
    public List<Film> findAll() {
        EntityManager em = EntityManagerWrapper.createEntityManager();
        try {
            return FilmDao.getInstance().findAll(em);
        } finally {
            em.close();
        }
    }
    
}
