package rs.ac.singidunum.cinemares.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import rs.ac.singidunum.cinemares.data.Film;


public class FilmDao {


    private static FilmDao instance = new FilmDao();

    public FilmDao() {
    }
    
    public static FilmDao getInstance(){
        
        return instance;
    }
    
    public List<Film> findAll(EntityManager em){
        TypedQuery<Film> query = em.createQuery("SELECT c FROM Film c", Film.class);
        return query.getResultList();
    }
    
    public void add(EntityManager em, Film film) {
        em.persist(film);
    }

    public void edit(EntityManager em, Film film) {
        em.merge(film);
    }

    public void delete(EntityManager em, Film film) {
        
        Film managedFilm = em.merge(film);
        em.remove(managedFilm);
    }
    
}
